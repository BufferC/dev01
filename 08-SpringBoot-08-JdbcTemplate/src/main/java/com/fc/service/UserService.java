package com.fc.service;

import com.fc.entity.User;

import java.util.List;

public interface UserService {
    // 查询全部
    List<User> findAll();
    // 根据id查询
    User findById(Integer id);
    // 查总数
    Integer findCount();
    // 插入
    int insert(User user);
    // 修改
    int update(User user);
    // 删除
    int delete(Integer id);
}
