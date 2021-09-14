package com.example.springplayground;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/pi")
    public String returnPi() {
        return "3.141592653589793";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam String operation, @RequestParam int x, @RequestParam int y){

     return String.format("%s %s %s = %s", x, MathService.getOperand(operation), y, MathService.calculate(operation, x, y));

    }

    @PostMapping("/sum")
    public String sum(@RequestParam MultiValueMap<String, String> input) {

        String sumString = "";

        for (int i = 0; i < input.get("n").size() - 1; i++){
            sumString += input.get("n").get(i);
            sumString += " + ";
        }

        sumString += input.get("n").get(input.get("n").size() - 1);
        sumString += " = " + String.valueOf(MathService.sum(input.get("n")));

        return sumString;
    }

    @RequestMapping("/volume/{x}/{y}/{z}")
    public String getVolume(@PathVariable int x, @PathVariable int y, @PathVariable int z){
        return String.format("The volume of a %sx%sx%s rectangle is %s", x, y, z, MathService.rectVolume(x, y, z));
    }
}

