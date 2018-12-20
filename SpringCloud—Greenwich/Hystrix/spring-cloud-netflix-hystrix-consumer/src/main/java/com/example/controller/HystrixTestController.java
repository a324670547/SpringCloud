package com.example.controller;

import com.example.service.HystrixTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HystrixTestController {
    @Autowired
    private HystrixTestService hystrixTestService;

    @GetMapping("/getValue")
    public String getTestValue() {
        return hystrixTestService.getTestValue();
    }

}