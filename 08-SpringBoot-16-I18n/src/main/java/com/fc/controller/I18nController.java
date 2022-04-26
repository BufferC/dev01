package com.fc.controller;

import com.fc.util.MessageUtil;
import com.fc.vo.LoginPageVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("i18n")
public class I18nController {
    @RequestMapping("get")
    public LoginPageVO get() {
        LoginPageVO loginPageVO = new LoginPageVO();

        loginPageVO.setTitle(MessageUtil.get("title"));
        loginPageVO.setUsername(MessageUtil.get("username"));
        loginPageVO.setPassword(MessageUtil.get("password"));
        loginPageVO.setWelcome(MessageUtil.get("welcome"));
        loginPageVO.setRememberMe(MessageUtil.get("rememberMe"));
        loginPageVO.setLogin(MessageUtil.get("login"));

        return loginPageVO;
    }
}
