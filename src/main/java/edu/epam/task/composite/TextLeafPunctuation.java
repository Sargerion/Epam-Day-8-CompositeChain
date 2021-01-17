package edu.epam.task.composite;

import java.util.List;

public class TextLeafPunctuation implements TextComponent{

    private Character punctuation;

    public TextLeafPunctuation(Character punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException();
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
        return String.valueOf(punctuation);
    }
}
