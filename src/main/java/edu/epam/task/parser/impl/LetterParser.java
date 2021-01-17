package edu.epam.task.parser.impl;

import edu.epam.task.composite.TextComponent;
import edu.epam.task.composite.TextComposite;
import edu.epam.task.composite.TextLeafLetter;
import edu.epam.task.parser.Handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LetterParser implements Handler {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public TextComponent handleRequest(String text) {
        TextComponent textComponent = new TextComposite();
        char[] letters = text.toCharArray();
        for (Character letter : letters) {
            textComponent.add(new TextLeafLetter(letter));
        }
        logger.info("Parse letter");
        return textComponent;
    }
}