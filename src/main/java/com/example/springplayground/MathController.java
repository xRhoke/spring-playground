package com.example.springplayground;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Map;

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

    @PostMapping("/area")
    public String getArea(@RequestParam Map<String, String> params){
        if (params.get("type").equals("circle")) {
            return String.format("Area of a %s with radius %s is %s", params.get("type"), params.get("radius"), MathService.circleArea(Integer.parseInt(params.get("radius"))));
        }
        if (params.get("type").equals("rectangle")) {
            return String.format("Area of a %sx%s rectangle is %s", params.get("width"), params.get("height"), MathService.rectArea(Integer.parseInt(params.get("height")), Integer.parseInt(params.get("width"))));
        }
        return "Invalid";

    }
}

