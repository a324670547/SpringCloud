package com.example.controller;

import com.example.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RibbonTestController {

    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/getValue")
    public String getTestValue() {
        return ribbonService.getValue();
    }

}