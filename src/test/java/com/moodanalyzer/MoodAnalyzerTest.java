package com.moodanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    @Test
    public void whenSadMessage_ShouldReturnSad()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in sad Mood");
        Assert.assertEquals("SAD",moodAnalyzer.analyzeMood());
    }

    @Test
    public void whenHappyMessage_ShouldReturnHappy()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in Happy mood");
        Assert.assertEquals("HAPPY", moodAnalyzer.analyzeMood());
    }
}
