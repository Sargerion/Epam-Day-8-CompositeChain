package edu.epam.task.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent{

    private List<TextComponent> components = new ArrayList<>();

    public TextComposite() {

    }

    public TextComposite(List<TextComponent> components) {
        this.components = components;
    }

    @Override
    public List<TextComponent> getComponents() {
        return new ArrayList<>(components);
    }

    @Override
    public boolean add(TextComponent component) {
        components.add(component);
        return true;
    }

    public boolean addAll(List<TextComponent> textComponents) {
        components.addAll(textComponents);
        return true;
    }

    @Override
    public TextComponent getComponent(int index) {
        return components.get(index);
    }

    @Override
    public boolean remove(TextComponent component) {
        components.remove(component);
        return true;
    }
    @Override
    public int getSize() {
        return components.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (TextComponent textComponent : components) {
            sb.append(textComponent.toString());
            if(textComponent.getClass() != TextLeafLetter.class) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
