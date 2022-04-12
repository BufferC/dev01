package com.fc.service;

import com.fc.vo.ResultVo;

import java.util.Map;

public interface CustomerService {
    ResultVo login(String username, String password);

    Map<String, Object> verify(String token);
}
