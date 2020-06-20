package com.moodanalyzer;

public class MoodAnalyzerException extends RuntimeException
{
    public enum ExceptionType
    {
        ENTERED_NULL,ENTERED_EMPTY
    }

    public ExceptionType exceptionType;

    public MoodAnalyzerException(String message,ExceptionType exceptionType)
    {
        super(message);
        this.exceptionType=exceptionType;
    }
}
