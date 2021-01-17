package edu.epam.task.composite;

import java.util.List;

public class TextLeafLetter implements TextComponent{

    private Character letter;

    public TextLeafLetter(Character character) {
        this.letter = character;
    }

    @Override
    public boolean add(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponent getComponent(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public String toString() {
        return String.valueOf(letter);
    }
}
