package com.fc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("登录模块")
@RestController
@RequestMapping("login")
public class LoginController {
    @PostMapping("userLogin")
    @ApiOperation("用户登录")
    public String login(String username, String password) {
        return "登录成功：" + username + ":" + password;
    }
}
