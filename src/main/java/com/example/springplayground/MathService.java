package com.example.springplayground;

import java.util.List;

public class MathService {

    public static int calculate(String operation, int x, int y){
        if (operation.equals("add")) {
            return x + y;
        }
        if (operation.equals("subtract")) {
            return x - y;
        }
        if (operation.equals("multiply")) {
            return x * y;
        }
        if (operation.equals("divide")) {
            return x / y;
        }
        return 0;
    }

    public static String getOperand(String operation){
        if (operation.equals("add")) return "+";
        if (operation.equals("subtract")) return "-";
        if (operation.equals("multiply")) return "*";
        if (operation.equals("divide")) return "/";
        return "no valid operand found";
    }

    public static int sum(List<String> intsToSum){
        int sum = 0;
        for (String n : intsToSum) {
            int m = Integer.parseInt(n);
            sum += m;
        }
        return sum;
    }
}
