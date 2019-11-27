package com.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerReflector {

    public static Constructor<?> getThisConstructor(Class...param) throws MoodAnalysisException
    {
        try
        {
            Class getClass = Class.forName("com.moodanalyser.MoodAnalyser");
            return getClass.getConstructor(param);
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Method Not Found");
        }
        catch (ClassNotFoundException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "Class Not Found");
        }
    }

    public static Object createObject(Constructor constructor, Object...message) throws MoodAnalysisException {
        try
        {
            return constructor.newInstance(message);
        }
        catch (InstantiationException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.INSTANT_CREATION_ERROR, "Issue with instance creation");
        }
        catch (IllegalAccessException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.CLASS_ILLEGAL_ACCESS, "Class "+constructor+ " access issue");
        }
        catch (InvocationTargetException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.CLASS_INVOCATION_ERROR, "Class invocation error");
        }
    }

    public static Object invokeMethod(Object objectClass, String methodName) throws MoodAnalysisException
    {
        try
        {
            return objectClass.getClass().getMethod(methodName).invoke(objectClass);
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, methodName+"Method Not Found");
        }
        catch (IllegalAccessException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_ILLEGAL_ACCESS,
                    "No access to method : "+methodName);
        }
        catch (InvocationTargetException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ERROR,
                    "Issue With invoking method : "+methodName);
        }
    }

    public static void setField(Object moodObject, String fieldName, String fieldValue) throws MoodAnalysisException
    {
        try
        {
            Field field = moodObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(moodObject, fieldValue);
        }
        catch (NoSuchFieldException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, fieldName+"  field Not Found");
        }
        catch (IllegalAccessException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.FIELD_ACCESSIBILITY_ERROR,
                    "No access to field "+fieldName);
        }
    }
}
