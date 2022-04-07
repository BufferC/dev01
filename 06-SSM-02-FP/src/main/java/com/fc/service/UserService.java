package com.fc.service;

import com.fc.entity.User;
import com.fc.vo.ResultVo;


public interface UserService {
    ResultVo del(Long id);

    ResultVo update(User user);

    ResultVo add(User user);

    ResultVo list(Integer pageNo, Integer pageSize, Long id);
}
