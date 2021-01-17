package edu.epam.task.action;

import edu.epam.task.composite.TextComponent;

import java.util.List;

public interface TextService {

    List<TextComponent> sortParagraphsByWordsCount(List<TextComponent> paragraphs);

    String findSentenceWithLongestWord();

    void deleteAllSentencesWhereWordCountLessThanKey(int key);

    List<String> findSameWords();
}
