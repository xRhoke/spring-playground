package com.example.springplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring!";
    }

    @GetMapping("/age")
    public String nameAndAge(@RequestParam("name") String name, @RequestParam("age") String age) {
        return String.format("%s is %s years old", name, age);
    }
}
