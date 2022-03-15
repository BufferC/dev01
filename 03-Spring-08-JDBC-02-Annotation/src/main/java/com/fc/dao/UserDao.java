package com.fc.dao;

import com.fc.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findById(Integer id);

    int findCount();

    int insert(User user);

    int update(User user);

    int delete(Integer id);
}
