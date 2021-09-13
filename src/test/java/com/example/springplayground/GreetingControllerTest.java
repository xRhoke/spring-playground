package com.example.springplayground;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
public class GreetingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void greetingControllerReturnsGreetingObjectAsJSON() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/greeting?id=3&name=bob");

        this.mvc.perform(request).andExpect(content().json("{\"id\":3,\"name\":\"bob\",\"message\":\"Hello, bob!\"}"));
    }
}
