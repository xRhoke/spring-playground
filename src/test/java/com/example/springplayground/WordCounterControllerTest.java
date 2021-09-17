package com.example.springplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class WordCounterControllerTest {

//    @Autowired
//    private WordCounter wordCounter;

    @Autowired
    private MockMvc mvc;

//    @Test
//    public void canGetWordCount(){
//        String message = "a brown cow ate a bale of hay";
//
//        Map<String, Integer> actual = wordCounter.count(message);
//        Map<String, Integer> expected = new HashMap<>();
//
//        expected.put("a", 2);
//        expected.put("brown", 1);
//        expected.put("cow", 1);
//        expected.put("ate", 1);
//        expected.put("bale", 1);
//        expected.put("of", 1);
//        expected.put("hay", 1);
//    }

    @Test
    public void controllerMockTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/words/count")
                .content("How now, brown cow");
        this.mvc.perform(request).andExpect(content().string("{\"How\":1,\"now\":1,\"cow\":1,\"brown\":1}"));
    }
}
