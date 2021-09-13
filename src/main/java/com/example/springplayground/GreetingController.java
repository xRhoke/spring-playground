package com.example.springplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greeting/{id}/{name}")
    public Greeting getGreetingWithPathVariables(Greeting greeting){
        return greeting;
    }

    @GetMapping("/greeting")
    public Greeting getGreetingWithQueryString(Greeting greeting){
        return greeting;
    }

}
