package com.fc.controller;

import com.fc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("transfer")
    public String transfer(Integer from, Integer to, Integer money) {
        accountService.transfer(from, to, money);

        return "转账成功";
    }
}
