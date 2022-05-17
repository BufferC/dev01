package com.fc.service.impl;

import com.fc.service.LoginService;
import com.fc.util.HashUtil;

import java.util.Map;

public class LoginServiceImpl implements LoginService {
    @Override
    public Map<String, String> getPasswordByUsername(String username) {
        return HashUtil.getCredential("123456");
    }
}
