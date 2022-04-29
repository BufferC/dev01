package com.fc.service;

import com.fc.vo.ResultVO;

public interface UserService {
    ResultVO login(String username, String password);
}
