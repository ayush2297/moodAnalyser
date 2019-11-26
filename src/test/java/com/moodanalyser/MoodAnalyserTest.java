package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void givenMood_whenSad_shouldReturnSAD(){
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in sad mood");
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMood_whenHappy_shouldReturnHAPPY(){
        MoodAnalyser moodAnalyser = new MoodAnalyser("i am in happy mood");
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMood_whenPassedNull_shouldThrowNullException(){
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NULL_MESSAGE,
                    e.type);
        }
    }

    @Test
    public void givenMood_whenPassedEmptyString_shouldThrowEmptyStringException(){
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.EMPTY_MESSAGE,
                    e.type);
        }
    }

//    @Test
//    public void givenMoodAnalyzer_className_shouldReturnMoodAnalyserObject(){
//        MoodAnalyser compareObject = new MoodAnalyser();
//        MoodAnalyser moodAnalyser = null;
//        try {
//            moodAnalyser = MoodAnalyzerFactory.createMoodAnalyzer();
//        } catch (MoodAnalysisException e) {
//            e.printStackTrace();
//        }
//        Assert.assertEquals(true, compareObject.equals(moodAnalyser));
//    }

    @Test
    public void givenClassName_whenImproper_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyzerFactory.createMoodAnalyzer();
        } catch (MoodAnalysisException e) {
            System.out.println("dassdasdasdasdsa\t "+e.type);
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMethodName_whenImproper_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyzerFactory.createMoodAnalyzer();
        } catch (MoodAnalysisException e) {
            System.out.println("dassdasdasdasdsa\t "+e.type);
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

//    @Test
//    public void givenClassName_whenImproper_shouldThrowMoodAnalysisException() {
//        try {
//            MoodAnalyser moodAnalyser = MoodAnalyzerFactory.createMoodAnalyzer();
//        } catch (MoodAnalysisException e) {
//            System.out.println("dassdasdasdasdsa\t "+e.type);
//            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
//        }
//    }
}
