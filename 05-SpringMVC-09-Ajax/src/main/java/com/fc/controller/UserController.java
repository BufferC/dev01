package com.fc.controller;

import com.fc.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping("register")
    public Map<String, Object> register(User user) {
        System.out.println(user);

        Map<String, Object> map = new HashMap<>();

        map.put("code", 200);
        map.put("message", "注册成功");
        map.put("success", true);
        map.put("data", "姐不狂但拽");

        return map;
    }

    @RequestMapping("registerJson")
    public Map<String, Object> registerJson(@RequestBody User user) {
        System.out.println(user);

        Map<String, Object> map = new HashMap<>();

        map.put("code", 200);
        map.put("message", "注册成功");
        map.put("success", true);
        map.put("data", "姐不狂但拽");

        return map;
    }
}
