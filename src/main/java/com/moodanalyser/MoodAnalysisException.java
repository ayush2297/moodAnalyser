package com.moodanalyser;

public class MoodAnalysisException extends Exception {
    enum ExceptionType {
            NULL_MESSAGE, EMPTY_MESSAGE
    }
    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message ){
        super(message);
        this.type = type;
    }

    public MoodAnalysisException( ExceptionType type) {
        this.type = type;
    }
}
