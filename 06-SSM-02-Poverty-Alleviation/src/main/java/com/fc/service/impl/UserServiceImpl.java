package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.entity.UserExample;
import com.fc.service.UserService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, User param) {
        List<User> users;

        ResultVO resultVO;

        try {
            if (param.getId() == null) {
                PageHelper.startPage(pageNum, pageSize);

                UserExample userExample = new UserExample();

                UserExample.Criteria criteria = userExample.createCriteria();

                if (param.getName() != null) {
                    criteria.andNameLike("%" + param.getName() + "%");
                }

                if (param.getUsername() != null) {
                    criteria.andUsernameLike("%" + param.getUsername() + "%");
                }

                if (param.getGender() != null) {
                    criteria.andGenderEqualTo(param.getGender());
                }

                users = userMapper.selectByExample(userExample);
            } else {
                User user = userMapper.selectByPrimaryKey(param.getId());
                users = new ArrayList<>();
                users.add(user);
            }

            PageInfo<User> pageInfo = new PageInfo<>(users);

            DataVO<User> dataVO = new DataVO<>(pageInfo.getTotal(), users, pageNum, pageSize);

            resultVO = new ResultVO(200, "OK", true, dataVO);
        } catch (Exception e) {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }

        return resultVO;
    }

    @Override
    public ResultVO add(User user) {
        if (user.getCreateTime() == null) {
            user.setCreateTime(new Date());
        }

        int affectedRows = userMapper.insertSelective(user);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "OK", true, user);
        } else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }

        return resultVO;
    }

    @Override
    public ResultVO update(User user) {
        int affectedRows = userMapper.updateByPrimaryKeySelective(user);

        ResultVO resultVO;

        if (affectedRows > 0) {
            User result = userMapper.selectByPrimaryKey(user.getId());

            resultVO = new ResultVO(200, "OK", true, result);
        } else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }

        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        int affectedRows = userMapper.deleteByPrimaryKey(id);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "OK", true, null);
        } else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }

        return resultVO;
    }
}
