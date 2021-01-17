package edu.epam.task.parser;

import edu.epam.task.composite.TextComponent;

@FunctionalInterface
public interface Handler {
    TextComponent handleRequest(String text);
}