package com.moodanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    MoodAnalyzer moodAnalyzer=new MoodAnalyzer();

    @Test
    public void whenSadMessage_ShouldReturnSad()
    {
        String mood=moodAnalyzer.analyzeMood("I am in a sad mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void whenHappyMessage_ShouldReturnHappy()
    {
        String mood = moodAnalyzer.analyzeMood("I am in a happy mood");
        Assert.assertEquals("HAPPY", mood);
    }
}
