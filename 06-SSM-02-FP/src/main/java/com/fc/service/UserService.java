package com.fc.service;

import com.fc.entity.User;
import com.fc.vo.ResultVo;

import java.util.Map;


public interface UserService {
    ResultVo del(Long id);

    ResultVo update(User user);

    ResultVo add(User user);

    ResultVo list(Integer pageNo, Integer pageSize, String name);

    ResultVo login(String username, String password);

    Map<String, Object> verify(String token);
}
