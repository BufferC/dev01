package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserDao;

    @Override
    public ResultVO login(String username, String password) {
        ResultVO resultVO;

        TbUserExample example = new TbUserExample();

        TbUserExample.Criteria criteria = example.createCriteria();

        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<TbUser> users = tbUserDao.selectByExample(example);

        if (users.size() > 0) {
            // 成功
            resultVO = new ResultVO(200, "登录成功", true, users.get(0));
        } else {
            // 失败
            resultVO = new ResultVO(0, "登录失败，用户名或密码错误", false, null);
        }

        return resultVO;
    }
}
