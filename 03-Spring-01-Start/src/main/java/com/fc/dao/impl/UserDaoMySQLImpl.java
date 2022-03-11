package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoMySQLImpl implements UserDao {
    @Override
    public void findAll() {
        System.out.println("MySQL...");
    }
}
