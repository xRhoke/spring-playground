package com.example.springplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest (MathController.class)
public class MathControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void returnsPi() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");

        this.mvc.perform(request).andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void testCalculateReturnsResultAsString() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=add&x=2&y=6");
        this.mvc.perform(request).andExpect(content().string("2 + 6 = 8"));

        request = MockMvcRequestBuilders.get("/math/calculate?operation=subtract&x=8&y=2");
        this.mvc.perform(request).andExpect(content().string("8 - 2 = 6"));

        request = MockMvcRequestBuilders.get("/math/calculate?operation=multiply&x=8&y=6");
        this.mvc.perform(request).andExpect(content().string("8 * 6 = 48"));

        request = MockMvcRequestBuilders.get("/math/calculate?operation=divide&x=12&y=6");
        this.mvc.perform(request).andExpect(content().string("12 / 6 = 2"));
    }

    @Test
    public void testSumReturnsResultAsString() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/sum?n=2&n=4&n=1");
        this.mvc.perform(request).andExpect(content().string("2 + 4 + 1 = 7"));
    }

    @Test
    public void testCanGetRectangleVolume() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/volume/3/4/5");
        this.mvc.perform(request).andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }
}
