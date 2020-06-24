package com.moodanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    MoodAnalyzer moodAnalyzer = new MoodAnalyzer();

    @Test
    public void whenSadMessage_shouldReturnSad() {
        String actualMessage = moodAnalyzer.analyzeMood("I am in a sad mood");
        Assert.assertEquals("SAD", actualMessage);
    }

    @Test
    public void whenHappyMessage_shouldReturnHappy() {
        String actualMessage = moodAnalyzer.analyzeMood("I am in a happy mood");
        Assert.assertEquals("HAPPY", actualMessage);
    }

    @Test
    public void whenNullMessage_shouldThrowException() {
        try {
            moodAnalyzer.analyzeMood(null);
        } catch (MoodAnalyzerException moodAnalyzerException) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_NULL, moodAnalyzerException.exceptionType);
        }
    }

    @Test
    public void whenEmptyMessage_shouldThrowException() {
        try {
            moodAnalyzer.analyzeMood("");
        } catch (MoodAnalyzerException moodAnalyzerException) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_EMPTY, moodAnalyzerException.exceptionType);
        }
    }
}
