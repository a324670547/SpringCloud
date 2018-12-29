package com.example.config;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon
 */

@Configuration
public class RestTemplateConfig {

    /**
     * 将restTemplate对象注入到Bean
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 随机负载均衡策略
     * @return
     */
    @Bean
    public IRule ribbonRule(){
        // 轮询
        return new RoundRobinRule();
        // 随机
        //return new RandomRule();
        // 权重
        //return new WeightedResponseTimeRule();
        // 区域感知轮询
        //return new ZoneAvoidanceRule();
    }

}