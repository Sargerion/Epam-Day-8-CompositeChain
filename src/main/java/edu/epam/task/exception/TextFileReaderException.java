package edu.epam.task.exception;

public class TextFileReaderException extends Exception {

    public TextFileReaderException() { }

    public TextFileReaderException(String message) {
        super(message);
    }

    public TextFileReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextFileReaderException(Throwable cause) {
        super(cause);
    }
}
