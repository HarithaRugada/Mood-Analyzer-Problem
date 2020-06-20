package com.moodanalyzer;

public class MoodAnalyzer
{
    String message;
    public MoodAnalyzer()
    {
        message="";
    }

    public MoodAnalyzer(String message)
    {
        this.message = message;
    }
    public String analyzeMood()
    {
        try
        {
            if (message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch(NullPointerException nullPointerException)
        {
            return "HAPPY";
        }
    }
}
