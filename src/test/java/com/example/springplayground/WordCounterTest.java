package com.example.springplayground;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WordCounterTest {

    @Test
    public void canReturnAMapWithWordCount(){
        WordCounter testWordCounter = new WordCounter();

        String message = "a brown cow ate a bale of hay";

        Map<String, Integer> actual = testWordCounter.count(message);
        Map<String, Integer> expected = new HashMap<>();

        expected.put("a", 2);
        expected.put("brown", 1);
        expected.put("cow", 1);
        expected.put("ate", 1);
        expected.put("bale", 1);
        expected.put("of", 1);
        expected.put("hay", 1);

        assertEquals(expected, actual);

    }

}
