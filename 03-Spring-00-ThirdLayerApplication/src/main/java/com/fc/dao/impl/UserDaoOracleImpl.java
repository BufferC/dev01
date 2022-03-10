package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void useJDBC() {
        System.out.println("Oracle....");
    }
}
