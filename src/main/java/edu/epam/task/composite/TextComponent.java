package edu.epam.task.composite;

import java.util.List;

public interface TextComponent {

    List<TextComponent> getComponents();

    boolean add(TextComponent component);

    TextComponent getComponent(int index);

    boolean remove(TextComponent component);

    int getSize();

    String toString();
}
