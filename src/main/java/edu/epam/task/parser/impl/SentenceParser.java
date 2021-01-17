package edu.epam.task.parser.impl;

import edu.epam.task.composite.TextComponent;
import edu.epam.task.composite.TextComposite;
import edu.epam.task.parser.Handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SentenceParser implements Handler {

    private static final Logger logger = LogManager.getLogger();
    private static final String REGEXP_SENTENCE_DELIMITER = "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";
    private WordParser wordParser;

    public SentenceParser(WordParser wordParser) {
        this.wordParser = wordParser;
    }

    @Override
    public TextComponent handleRequest(String text) {
        TextComponent textComponent = new TextComposite();
        Pattern pattern = Pattern.compile(REGEXP_SENTENCE_DELIMITER);
        Matcher matcher = pattern.matcher(text);
        logger.info("Sentence parse....");
        if (wordParser == null) {
            return textComponent;
        } else {
            while (matcher.find()) {
                TextComponent component = wordParser.handleRequest(matcher.group());
                logger.info("Request sent to word parser");
                component.add(component);
            }
        }
        return textComponent;
    }
}