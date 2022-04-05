package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public Map<String, Object> add(Collection collection) {
        int affection = collectionMapper.insertSelective(collection);
        Map<String, Object> map = new HashMap<>();
        if(affection == 1){
            map.put("message","收藏成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",affection);
        }else {
            map.put("message","收藏失败!");
            map.put("code",500);
            map.put("success",false);
            map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
        }
        return map;
    }

    @Override
    public Map<String, Object> del(long id) {
        int affection = collectionMapper.deleteByPrimaryKey(id);
        Map<String, Object> map = new HashMap<>();
        if(affection == 1){
            map.put("message","删除成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",affection);
        }else {
            map.put("message","删除失败!");
            map.put("code",500);
            map.put("success",false);
            map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
        }
        return map;
    }

    @Override
    public Map<String, Object> list(Integer pageNo, Integer pageSize, Integer id) {
        Map<String, Object> map = new HashMap<>();

        //数据总数
        long l = collectionMapper.countByExample(null);

        Map<String, Object> maps = new HashMap<>();

        maps.put( "total", l);

        if (id == null){
            PageHelper.startPage(pageNo, pageSize);
            List<Collection> page = collectionMapper.selectByExample(null);
            maps.put("list",page);
            if(!page.isEmpty()){
                map.put("message","获取成功!");
                map.put("code",200);
                map.put("success",true);
                map.put("data",maps);
            }else {
                map.put("message","获取失败!");
                map.put("code",404);
                map.put("success",false);
                map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
            }

        }else {
            long conId =  id.longValue();
            Collection collection = collectionMapper.selectByPrimaryKey(conId);
            maps.put("list",collection);
            if(collection != null){
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
