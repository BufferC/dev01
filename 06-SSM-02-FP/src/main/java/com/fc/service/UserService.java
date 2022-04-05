package com.fc.service;

import com.fc.entity.User;

import java.util.Map;


public interface UserService {
    Map<String, Object> del(String id);

    Map<String, Object> updata(User user);

    Map<String, Object> add(User user);

    Map<String, Object> list(String pageNo, String pageSize, String id);
}
