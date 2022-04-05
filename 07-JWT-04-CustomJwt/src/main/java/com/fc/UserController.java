package com.fc;

import com.fc.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping("login")
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> result = new HashMap<>();

        Map<String, Object> claim = new HashMap<>();
        if (username.equals("易烊千玺") && password.equals("123456")) {
            claim.put("auth", "admin");
        } else {
            claim.put("auth", "user");
        }

        String token = JwtUtil.getToken(claim, "qwertyui");

        result.put("token", token);
        result.put("code", 200);
        result.put("success", true);

        return result;
    }

    @RequestMapping("add")
    public Map<String, Object> add(String token) {
        Map<String, Object> map = JwtUtil.verify(token, "qwertyui");

        System.out.println(map);

        Boolean success = (Boolean) map.get("success");

        if (success) {
            Map<String, Object> data = (Map<String, Object>) map.get("data");

            String auth = (String) data.get("auth");

            if (auth.equals("admin")) {
                map.put("message", "Welcome Admin!!");
            } else {
                map.put("message", "No Auth!!!");
            }
        } else {
            map.put("message", "Invalid Token!!!");
        }

        return map;
    }

    @RequestMapping("show")
    public Map<String, Object> show(String token) {

        Map<String, Object> map = JwtUtil.verify(token, "qwertyui");

        Boolean success = (Boolean) map.get("success");

        if (success) {
            map.put("message", "Welcome LookLook!!!");
        } else {
            map.put("message", "Invalid Token!!!");
        }

        return map;
    }
}
