package com.fc.controller;

import com.fc.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
public class ConfigController {
    @Autowired
    private TestConfig config;

    @RequestMapping("get")
    public String test() {
        return config.test();
    }
}
