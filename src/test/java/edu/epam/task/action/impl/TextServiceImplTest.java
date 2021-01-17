package edu.epam.task.action.impl;

import edu.epam.task.action.TextService;
import edu.epam.task.composite.TextComponent;
import edu.epam.task.exception.TextFileReaderException;
import edu.epam.task.parser.Handler;
import edu.epam.task.parser.impl.ParagraphParser;
import edu.epam.task.reader.TextFileReader;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class TextServiceImplTest {

    public static final String FILE_PATH = "input_files/text_input.txt";
    static TextFileReader reader;
    static String text;
    static Handler handler;
    static TextComponent textComponent;
    static TextService textService;

    @BeforeClass
    public static void initialize() throws TextFileReaderException {
        reader = new TextFileReader();
        text = reader.read(FILE_PATH);
        handler = new ParagraphParser();
        textComponent = handler.handleRequest(text);
        textService = new TextServiceImpl();
    }

    @Test
    public void findSentenceWithLongestWordTest() {
        String actualResult = textService.findSentenceWithLongestWord(textComponent).toString();
        String expectedResult = textComponent.getComponent(0).getComponent(1).toString();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void findSameWordsCountTest() {
        int actualResult = textService.findSameWordsCount(textComponent, "A");
        int expectedResult = 7;
        assertEquals(actualResult, expectedResult);
    }

    @AfterClass
    public static void clear() {
        reader = null;
        text = null;
        handler = null;
        textComponent = null;
        textService = null;
    }
}
