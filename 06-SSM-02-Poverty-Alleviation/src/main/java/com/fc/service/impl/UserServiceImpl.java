package com.fc.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
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

import java.util.*;

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

    @Override
    public ResultVO login(String username, String password) {
        ResultVO resultVO = new ResultVO();

        // 用户名不存在
        resultVO.setData(null);
        resultVO.setSuccess(false);
        resultVO.setMessage("登录失败，当前用户名不存在");
        resultVO.setCode(-1);

        UserExample userExample = new UserExample();

        UserExample.Criteria criteria = userExample.createCriteria();

        criteria.andUsernameEqualTo(username);

        List<User> users = userMapper.selectByExample(userExample);

        // 说明当前用户名存在
        if (users != null && users.size() > 0) {
            User user = users.get(0);
            // 如果密码相同
            if (user.getPassword().equals(password)) {
                // 登录成功
                resultVO.setCode(200);
                resultVO.setSuccess(true);
                resultVO.setMessage("登录成功！");

                // 使用jwt -> json web token
                Map<String, Object> header = new HashMap<>();
                header.put("alg", "HS256");
                header.put("typ", "JWT");

                // 真实场景中绝对不能写死，一定要是一个动态的值或者是一个随机数
                // 数据库（性能低）
                // 缓存中（Redis）
                // 载荷（不安全）
                String salt = String.valueOf((int) ((Math.random() * 9 + 1) * 1000000));

                // 获取token
                String token = JWT.create()
                        .withHeader(header)
                        // 过期时间
                        // 尽可能得短，目前情况下我们先简单写死一个时间
                        // 后期会涉及一个问题：token续签问题
                        // token迟早是会过期的，又因为token使用的不可逆的加密算法，
                        // 一旦生成就再也不能改变了。
                        // 过期时间也是不能改变的。
                        // 我一直在进行使用，时间一到就过期！这不太合适
                        // 即便我真的把token的过期时间刷新了，载荷和签名全部都会发生改变
                        // token就不是刚开始那个了。
                        // 这不就续签（双token）
                        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 20))
                        // 签发人
                        .withIssuer("admin")
                        // 发布时间
                        .withIssuedAt(new Date())
                        // 主题
                        .withSubject("权限认证")
                        .withClaim("id", user.getId())
                        .withClaim("role", user.getRole())
                        .withClaim("username", username)
                        .withClaim("salt", salt)
                        // 签发
                        .sign(Algorithm.HMAC256(salt));

                Map<String, Object> data = new HashMap<>();

                user.setPassword(null);
                data.put("user", user);
                data.put("token", token);

                resultVO.setData(data);

            } else {
                // 密码错误，登录失败
                resultVO.setMessage("登录失败，密码错误！！！");
                resultVO.setCode(-2);
            }
        }

        return resultVO;
    }
}
