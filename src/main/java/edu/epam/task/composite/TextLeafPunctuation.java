package edu.epam.task.composite;

public class TextLeafPunctuation implements TextComponent{

    private Character punctuation;

    public TextLeafPunctuation(Character punctuation) {
        this.punctuation = punctuation;
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
