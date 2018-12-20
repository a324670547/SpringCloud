package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HystrixTestController {

    @GetMapping("/getValue")
    public String getTestValue() {
        return "Hello World!";
    }
}