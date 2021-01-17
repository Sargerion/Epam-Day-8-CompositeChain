package edu.epam.task.action;

import edu.epam.task.composite.TextComponent;

import java.util.List;

public interface TextService {

    TextComponent sortParagraphsBySentenceCount(TextComponent textComponent);

    TextComponent findSentenceWithLongestWord(TextComponent textComponent);

    TextComponent deleteAllSentencesWhereWordCountLessThanKey(TextComponent component, int key);

    int findSameWordsCount(TextComponent textComponent, String queryWord);
}
