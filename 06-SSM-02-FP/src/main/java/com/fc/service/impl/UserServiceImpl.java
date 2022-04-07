package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    public ResultVo list(Integer pageNo, Integer pageSize, Long id) {
        List<User> arrayList;
        PageInfo<User> userPageInfo;
        ResultVo resultVo ;

        try {
            if (id == null){
                PageHelper.startPage(pageNo, pageSize);
                arrayList = userMapper.selectByExample(null);
            }else {
                User user = userMapper.selectByPrimaryKey(id);
                arrayList = new ArrayList<>();
                if(user != null){
                    arrayList.add(user);
                }
            }
            //DataVo<Object> dataVo = new DataVo<>();
            userPageInfo = new PageInfo<>(arrayList);
            if (userPageInfo.getPageNum() != 0) {
                resultVo = new ResultVo("用户获取成功!", userPageInfo, true, 200);
            }else {
                resultVo = new ResultVo("用户获取失败!",null,false,404);
            }
        }catch (Exception e){
            resultVo = new ResultVo("用户获取异常!",null,false,500);
        }

        return resultVo;
    }


}
