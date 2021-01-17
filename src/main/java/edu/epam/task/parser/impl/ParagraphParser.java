package edu.epam.task.parser.impl;

import edu.epam.task.composite.TextComponent;
import edu.epam.task.composite.TextComposite;
import edu.epam.task.composite.TextLeafPunctuation;
import edu.epam.task.parser.Handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParagraphParser implements Handler {

    private static final Logger logger = LogManager.getLogger();
    private static final String REGEXP_PARAGRAPH_DELIMITER = "\\s{4}";
    private SentenceParser sentenceParser;

    public ParagraphParser(SentenceParser sentenceParser) {
        this.sentenceParser = sentenceParser;
    }

    @Override
    public TextComponent handleRequest(String text) {
        List<String> paragraphs = Stream.of(text.split(REGEXP_PARAGRAPH_DELIMITER)).collect(Collectors.toList());
        logger.info("Paragraphs parsed correctly ->\n{}", paragraphs);
        TextComponent textComponent = new TextComposite();
        if (sentenceParser == null) {
            return textComponent;
        } else {
            for (String paragraph : paragraphs) {
                if (paragraph.length() > 0) {
                    TextComponent componentParagraph = sentenceParser.handleRequest(paragraph);
                    textComponent.add(componentParagraph);
                }
            }
        }
        return textComponent;
    }
}
