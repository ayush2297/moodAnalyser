package com.moodanalyser;

public class MoodAnalyser {
    public String analyseMood(String message) {
        if(message.contains("happy")){
            return "HAPPY";
        } else if (message.contains("sad")){
            return "SAD";
        }
        return null;
    }
}
