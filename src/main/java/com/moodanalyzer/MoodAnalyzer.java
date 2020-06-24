package com.moodanalyzer;

public class MoodAnalyzer {
    public String analyzeMood(String message) {
        try {
            if (message.length() == 0) {
                throw new MoodAnalyzerException("Please enter a string that is not empty", MoodAnalyzerException.ExceptionType.ENTERED_EMPTY);
            }
            if (message.contains("sad"))
                return "SAD";

            else
                return "HAPPY";
        } catch (NullPointerException nullPointerException) {
            throw new MoodAnalyzerException("Please enter a proper mood message", MoodAnalyzerException.ExceptionType.ENTERED_NULL);
        }
    }
}
