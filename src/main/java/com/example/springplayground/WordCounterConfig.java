package com.example.springplayground;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WordCounterConfig {

    @Bean
    public WordCounter getWordCounter(){
        return new WordCounter();
    }
}
