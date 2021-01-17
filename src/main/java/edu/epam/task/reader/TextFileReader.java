package edu.epam.task.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.epam.task.exception.TextFileReaderException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

    private static final Logger logger = LogManager.getLogger();

    public String read(String inputFilePath) throws TextFileReaderException {
        File inputFile = new File(inputFilePath);
        if (!inputFile.exists()) {
            throw new TextFileReaderException("InputFile didn't exists");
        }
        if (inputFile.length() == 0) {
            throw new TextFileReaderException("Your file is empty");
        }
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new TextFileReaderException("Errors in reading -> " + e.getMessage());
        }
        logger.info("The file -> {} was read,\tResult ->\n{}", inputFilePath, stringBuilder);
        return stringBuilder.toString();
    }
}
