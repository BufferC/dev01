package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    //声明Dao层接口
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> del(String id) {
        long userId = Long.parseLong(id);

        Map<String, Object> map = new HashMap<>();

        int affection = userMapper.deleteByPrimaryKey(userId);

        if (affection == 1){
            map.put("message","用户删除成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",affection);
        }else {
            map.put("message","用户删除失败!");
            map.put("code",404);
            map.put("success",false);
            map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
        }



        return map;
    }

    @Override
    public Map<String, Object> updata(User user) {
        int affection = userMapper.updateByPrimaryKey(user);
        Map<String, Object> map = new HashMap<>();
        if (affection == 1){
            map.put("message","用户删除成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",affection);
        }else {
            map.put("message","用户删除失败!");
            map.put("code",404);
            map.put("success",false);
            map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
        }

        return map;
    }

    @Override
    public Map<String, Object> add(User user) {
        int affection = userMapper.insertSelective(user);

        Map<String, Object> map = new HashMap<>();

        if (affection == 1){
            map.put("message","用户添加成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",affection);
        }else {
            map.put("message","用户添加失败!");
            map.put("code",404);
            map.put("success",false);
            map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
        }

        return map;
    }

    @Override
    public Map<String, Object> list(String pageNo, String pageSize, String id) {
        Map<String, Object> map = new HashMap<>();

        //数据总数
        long l = userMapper.countByExample(null);

        Map<String, Object> maps = new HashMap<>();
        maps.put( "total", l);
        maps.put("pageNum" ,pageNo);
        maps.put("pageSize",pageSize);
        if (id == null){
            PageHelper.startPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
            List<User> page = userMapper.selectByExample(null);
            maps.put("list",page);
            if(!page.isEmpty()){
                map.put("message","用户获取成功!");
                map.put("code",200);
                map.put("success",true);
                map.put("data",maps);
            }else {
                map.put("message","用户获取失败!");
                map.put("code",404);
                map.put("success",false);
                map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
            }

        }else {
            long userId =  Long.parseLong(id);
            User user = userMapper.selectByPrimaryKey(userId);
            maps.put("list",user);
            if(user != null){
                map.put("message","用户获取成功!");
                map.put("code",200);
                map.put("success",true);
                map.put("data",maps);
            }else {
                map.put("message","用户获取失败!");
                map.put("code",404);
                map.put("success",false);
                map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
            }
        }
        return map;
    }


}
