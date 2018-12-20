package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixTestService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "errorValue")
    public String getTestValue() {
        return restTemplate.getForObject("http://SPRING-CLOUD-NETFLIX-HYSTRIX-PRODUCER/test/getValue", String.class);
    }

    public String errorValue() {
        return "error";
    }

}