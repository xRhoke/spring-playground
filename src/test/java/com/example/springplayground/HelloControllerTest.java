package com.example.springplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest (HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHomePage() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/");

        this.mvc.perform(request).andExpect(content().string("Hello from Spring!"));
    }

    @Test
    public void testAgeEndpoint() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/age?name=Elliott&age=28");

        this.mvc.perform(request).andExpect(status().isOk());
    }
}
