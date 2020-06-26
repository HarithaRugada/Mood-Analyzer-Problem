package com.moodanalyzer;

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
        MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("happy mood");
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
            MoodAnalyzerReflector.createMoodAnalyzer(null);
        } catch (MoodAnalyzerException moodAnalyzerException) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS, moodAnalyzerException.exceptionType);
        }
    }

    @Test
    public void givenClass_whenConstructor_Improper_shouldThrowException() {
        try {
            MoodAnalyzerReflector.createMoodAnalyzer(null);
        } catch (MoodAnalyzerException moodAnalyzerException) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, moodAnalyzerException.exceptionType);
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProper_withParameter_shouldReturnObject() {
        //String mood=moodAnalyzer.analyzeMood();
        //Assert.assertEquals("HAPPY",mood);
        MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("I am in a sad mood");
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalyzerException moodAnalyzerException) {
            moodAnalyzerException.printStackTrace();
        }
    }

    @Test
    public void givenClassName_whenImproper_withParameter_shouldThrowException() {
        //MoodAnalyzer moodAnalyzer=null;
        try {
            MoodAnalyzerReflector.createMoodAnalyzer(null);
        } catch (MoodAnalyzerException moodAnalyzerException) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS, moodAnalyzerException.exceptionType);
        }
    }

    @Test
    public void givenClass_whenConstructor_Improper_withParameter_shouldThrowException() {
        try {
            MoodAnalyzerReflector.createMoodAnalyzer(null);
        } catch (MoodAnalyzerException moodAnalyzerException) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, moodAnalyzerException.exceptionType);
        }
    }

    @Test
    public void givenSadMood_shouldReturnSad_usingReflection() {
        String mood = MoodAnalyzerReflector.invokeAnalyzeMood("com.moodanalyzer.MoodAnalyzer", "analyzeMood", "I am in sad mood");
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenSadMood_shouldReturnSad_improperMood_usingReflection() {
        try {
            MoodAnalyzerReflector.invokeAnalyzeMood("com.moodanalyzer.MoodAnalyzer", "analyseMood", "I am in a sad mood ");
        } catch (MoodAnalyzerException moodAnalyzerException) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, moodAnalyzerException.exceptionType);
        }
    }

    @Test
    public void givenHappyMood_shouldReturnHappy_throughReflector() {
        MoodAnalyzerReflector.dynamicMood("com.moodanalyzer.MoodAnalyzer", "analyzeMood", "in a happy mood", "message");
        String mood = MoodAnalyzerReflector.invokeAnalyzeMood("com.moodanalyzer.MoodAnalyzer", "analyzeMood", "happy mood");
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenField_improper_shouldThrowException() {
        try {
            MoodAnalyzerReflector.dynamicMood("com.moodanalyzer.MoodAnalyzer", "analyzeMood", "happy mood", "");
        } catch (MoodAnalyzerException moodAnalyzerException) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_FIELD, moodAnalyzerException.exceptionType);
        }
    }

    @Test
    public void givenField_null_shouldThrowException() {
        try {
            MoodAnalyzerReflector.dynamicMood("com.moodanalyzer.MoodAnalyzer", "analyzeMood", "happy mood", null);
        } catch (NullPointerException nullPointerException) {
            System.out.println("Null Pointer Exception");
        }
    }
}
