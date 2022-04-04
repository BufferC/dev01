package com.fc.service.impl;

import com.fc.service.UserService;
import com.fc.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserVO login(String username, String password) {
        // 连接数据库
        UserVO userVO = null;

        if (username.equals("易烊千玺") && password.equals("123456")) {
             userVO = new UserVO();
             userVO.setId(1);
             userVO.setUsername(username);
             userVO.setLastAccessTime(new Date());
        }

        return userVO;
    }
}
