package com.fc.service;

public interface AccountService {
    // 转账
    void transfer(Integer from, Integer to, Long money);
}
