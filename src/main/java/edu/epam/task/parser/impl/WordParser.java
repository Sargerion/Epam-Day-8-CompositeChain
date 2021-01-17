package edu.epam.task.parser.impl;

import edu.epam.task.composite.TextComponent;
import edu.epam.task.composite.TextComposite;
import edu.epam.task.composite.TextLeafPunctuation;
import edu.epam.task.parser.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements Handler {

    private static final Logger logger = LogManager.getLogger();
    private static final String REGEXP_LEXEME_DETECT = "[а-яА-Я\\w]+[,.?!]";
    private static final String REGEXP_LEXEME_DELIMITER = "\\s";
    private static final String REGEXP_WORD_DELIMITER = "[а-яА-Я\\w]+";
    private LetterParser letterParser;

    public WordParser(LetterParser letterParser) {
        this.letterParser = letterParser;
    }

    @Override
    public TextComponent handleRequest(String text) {
        String[] lexemes = text.split(REGEXP_LEXEME_DELIMITER);
        TextComponent textComponent = new TextComposite();
        if (letterParser == null) {
            logger.error("Letter parser = null");
            return textComponent;
        } else {
            for (String lexeme : lexemes) {
                if (lexeme.matches(REGEXP_WORD_DELIMITER)) {
                    textComponent.add(letterParser.handleRequest(lexeme));
                    logger.info("Detect word -> {}\nRequest sent to letter parser", lexeme);
                } else if (lexeme.matches(REGEXP_LEXEME_DETECT)) {
                    textComponent.add(letterParser.handleRequest(lexeme.substring(0, lexeme.length() - 1)));
                    logger.info("Detect lexeme -> {}\nRequest sent to letter parser", lexeme);
                    textComponent.add(new TextLeafPunctuation(lexeme.charAt(lexeme.length() - 1)));
                } else {
                    textComponent.add(new TextLeafPunctuation(lexeme.charAt(lexeme.length() - 1)));
                }
            }
        }
        return textComponent;
    }
}