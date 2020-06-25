package com.moodanalyzer;

public class MoodAnalyzerException extends RuntimeException {
    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_METHOD, NO_SUCH_CLASS, NO_FIELD
    }

    public ExceptionType exceptionType;

    public MoodAnalyzerException(String message, ExceptionType exceptionType) {
        super(message);
        this.exceptionType = exceptionType;
    }
}
