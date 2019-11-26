package com.moodanalyser;

public class MoodAnalyser {
    private String message ;
    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {

    }

    public String analyseMood() {
        if(message.contains("sad")){
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}
