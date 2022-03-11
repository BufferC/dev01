package com.fc.util;

import com.fc.dao.UserDao;
import com.fc.dao.impl.UserDaoImpl;

public class UserDaoStaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
