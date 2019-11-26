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

    @Test
    public void givenClassName_whenHasNoProperClass_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyzerFactory.createMoodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMethodName_whenHasNoProperConstructor_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyzerFactory.createMoodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Test
    public void givenReflection_whenCreatesProperClass_shouldReturnTrue() {
        MoodAnalyser moodAnalyser=null;
        try {
            moodAnalyser = MoodAnalyzerFactory.createMoodAnalyzer("this is a happy message");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals((new MoodAnalyser("this is a happy message")),moodAnalyser);
        }
    }


    @Test
    public void givenClassNameWithParams_whenHasNoProperClass_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyzerFactory.createMoodAnalyzer("this is a sad message");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMethodNameWithParams_whenHasNoProperConstructor_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyzerFactory.createMoodAnalyzer("this is a happy message");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }


}
