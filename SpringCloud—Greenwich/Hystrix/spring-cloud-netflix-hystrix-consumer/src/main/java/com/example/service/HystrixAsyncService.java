package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.Future;

@Service
public class HystrixAsyncService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "asycnFallBack")
    public Future<String> getAsycnValue(){
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForObject("http://SPRING-CLOUD-HYSTRIX-PRODUCER/test/getValue", String.class);
            }
        };
    }

    public String asycnFallBack() {
        return "error";
    }
}
