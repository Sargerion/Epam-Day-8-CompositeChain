package edu.epam.task.composite;

import java.util.List;

public interface TextComponent {

    boolean add(TextComponent component);

    TextComponent getComponent(int index);

    boolean remove(TextComponent component);

    int getSize();
}
