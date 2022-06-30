package com.fc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping
public class BlogConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX="http://localhost:8686";//生产方

    @GetMapping("/consumer/blog")
    public String get(){
        return "消费端："+restTemplate.getForObject(REST_URL_PREFIX +"/blog/discovery", String.class);
    }
}
