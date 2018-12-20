package com.example.controller;

import com.example.service.HystrixAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/async")
public class HystrixASyncController {

    @Autowired
    private HystrixAsyncService hystrixAsyncService;

    @GetMapping("/getValue")
    public String getTestAsyncValue() {
        String result = null;
        try {
            Future<String> apiResult = hystrixAsyncService.getAsycnValue();
            result = apiResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
}
