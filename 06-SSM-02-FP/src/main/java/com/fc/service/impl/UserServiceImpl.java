package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.entity.UserExample;
import com.fc.service.UserService;
import com.fc.util.JwtUtil;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    //声明Dao层接口
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVo del(Long id) {
        ResultVo resultVo;
        int affection = userMapper.deleteByPrimaryKey(id);
        if (affection == 1){
            resultVo = new ResultVo("用户删除成功!",affection,true,200);
        }else {
            resultVo = new ResultVo("用户删除失败!",null,false,404);
        }
        return resultVo;
    }

    @Override
    public ResultVo update(User user) {
        ResultVo resultVo;
            int affection = userMapper.updateByPrimaryKeySelective(user);
            if (affection == 1){
                resultVo = new ResultVo("用户修改成功!",userMapper.selectByPrimaryKey(user.getId()),true,200);
            }else {
                resultVo = new ResultVo("用户修改失败!", null, false, 404);
            }
        return resultVo;
    }

    @Override
    public ResultVo add(User user) {
        System.out.println(user.getPhoto());
        if (user.getCreateTime() == null){
            user.setCreateTime(new Date());
        }
        ResultVo resultVo;
        try {
            int affection = userMapper.insertSelective(user);
            if (affection == 1){
                resultVo = new ResultVo("用户添加成功!",userMapper.selectByPrimaryKey(user.getId()),true,200);
            }else {
                resultVo = new ResultVo("用户添加失败!",null,false,404);
            }
        }catch (Exception e){
            resultVo = new ResultVo("参数异常!",null,false,404);
        }
        return resultVo;
    }

    @Override
    public ResultVo list(Integer pageNo, Integer pageSize, String name) {
        List<User> arrayList;
        PageInfo<User> userPageInfo;
        ResultVo resultVo ;
        PageHelper.startPage(pageNo, pageSize);
        try {
            if (name == null|| name.equals("")){
                arrayList = userMapper.selectByExample(null);
            }else {
                UserExample userExample = new UserExample();
                UserExample.Criteria criteria = userExample.createCriteria();
                criteria.andNameLike("%"+name+"%");
                arrayList = userMapper.selectByExample(userExample);
            }
            //DataVo<Object> dataVo = new DataVo<>();
            userPageInfo = new PageInfo<>(arrayList);
            if (!arrayList.isEmpty()) {
                resultVo = new ResultVo("用户获取成功!", userPageInfo, true, 200);
            }else {
                resultVo = new ResultVo("没有查到!",null,true,404);
            }
        }catch (Exception e){
            resultVo = new ResultVo("用户获取异常!",null,false,500);
        }

        return resultVo;
    }

    @Override
    public ResultVo login(String username, String password) {
        int id = userMapper.findLogin(username,password);
        ResultVo resultVo;
        if (id == 0) {
            resultVo = new ResultVo("登录失败...",null,false,-1);
        } else {
            Map<String, Object> claim = new HashMap<>();

            claim.put("username", username);
            claim.put("id", id);

            String token = JwtUtil.getToken(claim);

            resultVo = new ResultVo("登录成功...",token,true,200);
        }
        return resultVo;
    }

    @Override
    public Map<String, Object> verify(String token) {
        Map<String, Object> verify = JwtUtil.verify(token);
        return verify;
    }


}
