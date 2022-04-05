package com.fc.service.impl;

import com.fc.dao.AlleviationMapper;
import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlleviationServiceImpl implements AlleviationService {
    @Autowired
    private AlleviationMapper alleviationMapper;

    @Override
    public Map<String, Object> add(Alleviation alleviation) {
        int affection = alleviationMapper.insertSelective(alleviation);
        Map<String, Object> map = new HashMap<>();
        if(affection == 1){
            map.put("message","添加成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",affection);
        }else {
            map.put("message","添加失败!");
            map.put("code",500);
            map.put("success",false);
            map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
        }
        return map;
    }

    @Override
    public Map<String, Object> updata(Alleviation alleviation) {
        int affection = alleviationMapper.updateByPrimaryKey(alleviation);
        Map<String, Object> map = new HashMap<>();
        if (affection == 1){
            map.put("message","修改成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",affection);
        }else {
            map.put("message","修改失败!");
            map.put("code",404);
            map.put("success",false);
            map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
        }

        return map;
    }

    @Override
    public Map<String, Object> del(Integer id) {
        int affection = alleviationMapper.deleteByPrimaryKey(id.longValue());
        Map<String, Object> map = new HashMap<>();
        if (affection == 1){
            map.put("message","删除成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",affection);
        }else {
            map.put("message","删除失败!");
            map.put("code",404);
            map.put("success",false);
            map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
        }

        return map;
    }

    @Override
    public Map<String, Object> list(Integer pageNo, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();

        //数据总数
        long l = alleviationMapper.countByExample(null);

        Map<String, Object> maps = new HashMap<>();
        maps.put( "total", l);


            PageHelper.startPage(pageNo, pageSize);
            List<Alleviation> page = alleviationMapper.selectByExample(null);
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
        return map;
    }

    @Override
    public Map<String, Object> click(Integer id, Date clicktime) {
        Integer num = alleviationMapper.clickNum(id);
        if (num == null){
            num = 0;
        }
        num++;
        System.out.println(id+"******"+clicktime+"********"+num);
        int affection = alleviationMapper.clickUp(id.longValue(),clicktime, num);
        Map<String, Object> map = new HashMap<>();
        if (affection == 1){
            map.put("message","设置成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",affection);
        }else {
            map.put("message","设置失败!");
            map.put("code",404);
            map.put("success",false);
            map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
        }

        return map;
    }
}
