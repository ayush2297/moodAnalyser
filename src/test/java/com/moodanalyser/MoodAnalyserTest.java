package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {

    @Test
    public void givenMessage_WhenSad_ReturnSad() throws MoodAnalysisException
    {
        MoodAnalyser moodAnalyse = new MoodAnalyser("I am in sad mood");
        Assert.assertEquals("SAD", moodAnalyse.analyseMood());
    }

    @Test
    public void givenMessage_WhenHappy_ReturnHappy() throws MoodAnalysisException
    {
        MoodAnalyser moodAnalyse = new MoodAnalyser("I am in happy mood");
        Assert.assertEquals("HAPPY", moodAnalyse.analyseMood());
    }

    @Test
    public void givenMessage_WhenNull_ThrowsNullException()
    {
        MoodAnalyser moodAnalyse = new MoodAnalyser(null);
        try
        {
            moodAnalyse.analyseMood();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NULL_MESSAGE , e.type);
        }
    }

    @Test
    public void givenMessage_WhenNull_ThrowsException_UsingEnum()
    {
        MoodAnalyser moodAnalyse = new MoodAnalyser(null);
        try
        {
            moodAnalyse.analyseMood();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NULL_MESSAGE, e.type);
        }
    }

    @Test
    public void givenMessage_WhenEmpty_ThrowsException_UsingEnum()
    {
        MoodAnalyser moodAnalyse = new MoodAnalyser("");
        try
        {
            moodAnalyse.analyseMood();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.EMPTY_MESSAGE, e.type);
        }
    }

    @Test
    public void givenClassName_WhenEquals_CreatesObject() throws MoodAnalysisException
    {
        Constructor constructor = MoodAnalyzerReflector.getThisConstructor(String.class);
        Object moodObject = MoodAnalyzerReflector.createObject(constructor,"i am in happy mood");
        Assert.assertEquals(new MoodAnalyser("I am in happy mood"),moodObject);

    }

    @Test
    public void givenClassname_WhenImproper_HandlesException()
    {
        try
        {
            Constructor constructor = MoodAnalyzerReflector.getThisConstructor();
            Object moodObject = MoodAnalyzerReflector.createObject(constructor);
            Assert.assertEquals( new MoodAnalyser(),moodObject);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenClassname_WhenConstructorNotFound_HandlesException()
    {
        try
        {
            MoodAnalyser moodAnalyse = new MoodAnalyser();
            Constructor constructor = MoodAnalyzerReflector.getThisConstructor();
            Object moodObject = MoodAnalyzerReflector.createObject(constructor);
            Assert.assertEquals(moodAnalyse,moodObject);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenClassName_WhenEquals_CreatesObject_UsingParameters() throws MoodAnalysisException
    {
        Constructor constructor = MoodAnalyzerReflector.getThisConstructor(String.class);
        Object moodObject = MoodAnalyzerReflector.createObject(constructor,"New Object");
        Assert.assertEquals(new MoodAnalyser("New Object"),moodObject);
    }

    @Test
    public void givenClassname_WhenImproper_HandlesException_UsingConstructor()
    {
        try
        {
            MoodAnalyser moodAnalyse = new MoodAnalyser();
            Constructor constructor = MoodAnalyzerReflector.getThisConstructor();
            Object moodObject = MoodAnalyzerReflector.createObject(constructor);
            Assert.assertEquals(moodAnalyse,moodObject);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenClassname_WhenConstructorNotFound_HandlesException_UsingConstructor()
    {
        try
        {
            MoodAnalyser moodAnalyse = new MoodAnalyser("I am in happy mood");
            Constructor constructor = MoodAnalyzerReflector.getThisConstructor(String.class);
            Object moodObject = MoodAnalyzerReflector.createObject(constructor,"I am in happy mood");
            Assert.assertEquals(moodAnalyse,moodObject);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenHappyMessage_WithReflectionShouldReturnHappy()
    {
        try
        {
            Constructor constructor = MoodAnalyzerReflector.getThisConstructor();
            Object moodObject = MoodAnalyzerReflector.createObject(constructor);
            Object mood = MoodAnalyzerReflector.invokeMethod(moodObject, "analyseMood");
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ERROR, e.type);
        }
    }

    @Test
    public void givenObject_onChangeMoodDynamically_ShouldReturnHappy()
    {
        try
        {
            Constructor constructor = MoodAnalyzerReflector.getThisConstructor();
            Object moodObject = MoodAnalyzerReflector.createObject(constructor);
            MoodAnalyzerReflector.setField(moodObject, "message", "I am in happy mood");
            Object mood = MoodAnalyzerReflector.invokeMethod(moodObject, "analyseMood");
            Assert.assertEquals("HAPPY", mood);

        }
        catch (MoodAnalysisException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessage_WhenHappy_ReturnHappy_usingDefaultConstructor() throws MoodAnalysisException
    {
        Constructor constructor = MoodAnalyzerReflector.getThisConstructor();
        Object moodObject = MoodAnalyzerReflector.createObject(constructor);
        MoodAnalyzerReflector.setField(moodObject, "message", "I am in happy mood");
        Object mood = MoodAnalyzerReflector.invokeMethod(moodObject, "analyseMood");
        Assert.assertEquals("HAPPY", mood);
    }
}
