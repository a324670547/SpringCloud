package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;

    public String getValue(){
        return restTemplate.getForObject("http://SPRING-CLOUD-NETFLIX-RIBBON-PRODUCER/test/getValue", String.class);
    }
}
