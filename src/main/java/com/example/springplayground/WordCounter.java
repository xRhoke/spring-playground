package com.example.springplayground;

import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public Map<String, Integer> count(String message){
        String[] splitMessage = message.split(" ");

        //Remove punctuation
        for(int i = 0; i < splitMessage.length; i++) {
            if (splitMessage[i].contains(",") || splitMessage[i].contains(".")) {
                splitMessage[i] = splitMessage[i].substring(0, splitMessage[i].length() - 1);
            }
        }

        Map<String, Integer> wordCount = new HashMap<>();

        for(String word : splitMessage) wordCount.put(word, 0);
        for(String word : splitMessage) wordCount.put(word, wordCount.get(word) + 1);

        return wordCount;
    }
}
