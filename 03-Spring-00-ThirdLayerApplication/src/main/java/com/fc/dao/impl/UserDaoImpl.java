package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void useJDBC() {
        System.out.println("使用JDBC连接数据库，查询~~~");
    }
}
