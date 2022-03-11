package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void findAll() {
        System.out.println("连接了数据库，执行了SQL语句....");
    }
}
