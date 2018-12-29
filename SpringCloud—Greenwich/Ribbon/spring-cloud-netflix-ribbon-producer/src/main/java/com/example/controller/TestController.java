package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${info.name}")
    String info;

    @GetMapping("/getValue")
    public String getTestValue() {
        return "Hello World! 1 " + info;
    }

}