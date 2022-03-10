package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoMySQLImpl implements UserDao {
    @Override
    public void useJDBC() {
        System.out.println("MySQL....");
    }
}
