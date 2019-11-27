package com.moodanalyser;

public class MoodAnalysisException extends Exception {
    enum ExceptionType {
            NULL_MESSAGE, EMPTY_MESSAGE, NO_SUCH_CLASS, NO_SUCH_METHOD, NO_SUCH_FIELD, METHOD_INVOCATION_ERROR,
        FIELD_ACCESSIBILITY_ERROR, CLASS_INVOCATION_ERROR, CLASS_ILLEGAL_ACCESS, METHOD_ILLEGAL_ACCESS, INSTANT_CREATION_ERROR ;
    }
    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message ){
        super(message);
        this.type = type;
    }

    public MoodAnalysisException(ExceptionType type, String message, Throwable cause ){
        super(message);
        this.type = type;
    }

    public MoodAnalysisException( ExceptionType type) {
        this.type = type;
    }
}
