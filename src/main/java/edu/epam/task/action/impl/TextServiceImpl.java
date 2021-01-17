package edu.epam.task.action.impl;

import edu.epam.task.action.TextService;
import edu.epam.task.composite.TextComponent;
import edu.epam.task.composite.TextComposite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class TextServiceImpl implements TextService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public TextComponent sortParagraphsBySentenceCount(TextComponent paragraphs) {
        List<TextComponent> paragraphList = paragraphs.getComponents();
        paragraphList.sort(Comparator.comparing(TextComponent::getSize));
        logger.info("Sort Paragraphs By Sentence Count complete\n");
        return new TextComposite(paragraphList);
    }

    @Override
    public TextComponent findSentenceWithLongestWord(TextComponent textComponent) {
        TextComponent result = null;
        int maxWordSize = 0;
        List<TextComponent> paragraphList = textComponent.getComponents();
        for (TextComponent paragraph : paragraphList) {
            List<TextComponent> sentenceList = paragraph.getComponents();
            for (TextComponent sentence : sentenceList) {
                List<TextComponent> wordList = sentence.getComponents();
                for (TextComponent word : wordList) {
                    if (word.getSize() > maxWordSize) {
                        maxWordSize = word.getSize();
                        result = sentence;
                    }
                }
            }
        }
        logger.info("Sentence with longest word ->\n{}", result);
        return result;
    }

    @Override
    public TextComponent deleteAllSentencesWhereWordCountLessThanKey(TextComponent component, int key) {
        List<TextComponent> paragraphList = component.getComponents();
        for (TextComponent paragraph : paragraphList) {
            List<TextComponent> sentenceList = paragraph.getComponents();
            for (TextComponent sentence : sentenceList) {
                if (sentence.getSize() <= key) {
                    paragraph.remove(sentence);
                }
            }
        }
        return new TextComposite(paragraphList);
    }

    @Override
    public int findSameWordsCount(TextComponent textComponent, String queryWord) {
        int sameWordsCount = 0;
        List<TextComponent> paragraphList = textComponent.getComponents();
        for (TextComponent paragraph : paragraphList) {
            List<TextComponent> sentenceList = paragraph.getComponents();
            for (TextComponent sentence : sentenceList) {
                List<TextComponent> wordList = sentence.getComponents();
                for (TextComponent word : wordList) {
                    String checkWord = word.toString();
                    if(checkWord.compareToIgnoreCase(queryWord) == 0) {
                        sameWordsCount++;
                    }
                }
            }
        }
        logger.info("Count of same words in text -> {}", sameWordsCount);
        return sameWordsCount;
    }
}