package com.moodanalyser;

public class MoodAnalyser {
    public String message = null;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if(message.length() == 0){
                throw new MoodAnalysisException( MoodAnalysisException.ExceptionType.EMPTY_MESSAGE ,
                        "please provide proper input") ;
            }
            if (message.contains("sad")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NULL_MESSAGE ,
                    "please enter proper message");
        }
    }

    public boolean equals(MoodAnalyser obj) {
        if((this.message) == (obj.message)) {
            return true;
        }
        return false;
    }
}
