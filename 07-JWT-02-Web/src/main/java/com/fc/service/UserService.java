package com.fc.service;

import com.fc.vo.UserVO;

public interface UserService {
    UserVO login(String username, String password);
}
