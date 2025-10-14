package com.example.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public Map<String, Object> add(@RequestParam int a, @RequestParam int b) {
        return Map.of("result", a + b);
    }

    @GetMapping("/subtract")
    public String subtract(int a, int b){
        return String.valueOf(a-b);
    }

    @GetMapping("/multiply")
    public String multiply(int a, int b){
        return String.valueOf(a*b);
    }

    @GetMapping("/divide")
    public String divide(int a, int b){
        return String.valueOf(a/b);
    }

    @GetMapping("/")
    public String index(){
        return "Error 405";
    }
}
