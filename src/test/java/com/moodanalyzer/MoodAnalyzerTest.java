package com.moodanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    @Test
    public void whenSadMessage_shouldReturnSad()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in sad Mood");
        Assert.assertEquals("SAD",moodAnalyzer.analyzeMood());
    }

    @Test
    public void whenHappyMessage_shouldReturnHappy()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in Happy mood");
        Assert.assertEquals("HAPPY", moodAnalyzer.analyzeMood());
    }

    @Test
    public void whenNullMessage_shouldReturnHappy()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer(null);
        Assert.assertEquals("HAPPY",moodAnalyzer.analyzeMood());
    }
}
