package com.fc.service;

import com.fc.dao.UserDao;

public interface UserService {
    void useJDBC();

    void setUserDao(UserDao userDao);
}
