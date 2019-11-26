package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void givenMood_whenSad_shouldReturnTrue(){
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("this is a sad message");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMood_whenHappy_shouldReturnTrue(){
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("this is a happy message");
        Assert.assertEquals("HAPPY",mood);
    }

}
