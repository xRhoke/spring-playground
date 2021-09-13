package com.example.springplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {

    @GetMapping("/individual-example/{q}/{from}")
    public String getIndividualParams(@PathVariable String from, @PathVariable("q") String query){
        return String.format("q:%s from:%s", query, from);
    }
}
