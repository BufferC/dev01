package com.fc.service.impl;

import com.fc.service.LoginService;

public class LoginServiceImpl implements LoginService {
    @Override
    public String getPasswordByUsername(String username) {
        return "123456";
    }
}
