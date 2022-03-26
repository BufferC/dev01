package com.fc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("crossOrigin")

public class CrossController {
    //@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
    @RequestMapping("get")
    public Map<String, Object> get() {
        System.out.println("执行Controller");

        Map<String, Object> map = new HashMap<>();

        map.put("code", 200);
        map.put("message", "请求成功");

        return map;
    }
}
