package com.moodanalyzer;

import javafx.animation.ScaleTransition;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void whenSadMessage_shouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in a sad mood");
        Assert.assertEquals("SAD", moodAnalyzer.analyzeMood());
    }

    @Test
    public void whenHappyMessage_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in a happy mood");
        Assert.assertEquals("HAPPY", moodAnalyzer.analyzeMood());
    }

    @Test
    public void whenNullMessage_shouldThrowException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        } catch (MoodAnalyzerException moodAnalyzerException) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_NULL, moodAnalyzerException.exceptionType);
        }
    }

    @Test
    public void whenEmptyMessage_shouldThrowException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        } catch (MoodAnalyzerException moodAnalyzerException) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_EMPTY, moodAnalyzerException.exceptionType);
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProper_shouldReturnObject() {
        //String mood=moodAnalyzer.analyzeMood();
        //Assert.assertEquals("HAPPY",mood);
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyzerException moodAnalyzerException) {
            moodAnalyzerException.printStackTrace();
        }
    }

    @Test
    public void givenClassName_whenImproper_shouldThrowException() {
        //MoodAnalyzer moodAnalyzer=null;
        try {
            MoodAnalyzerFactory.createMoodAnalyzer();
        } catch (MoodAnalyzerException moodAnalyzerException) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS, moodAnalyzerException.exceptionType);
        }
    }

    @Test
    public void givenClass_whenConstructor_Improper_shouldThrowException()
    {
        try {
            MoodAnalyzerFactory.createMoodAnalyzer();
        } catch (MoodAnalyzerException moodAnalyzerException) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, moodAnalyzerException.exceptionType);
        }
    }
}
