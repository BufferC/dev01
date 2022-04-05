package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.Poor;
import com.fc.entity.PoorExample;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;
    @Override
    public Map<String, Object> add(PoorWithBLOBs poor) {
        int affection = poorMapper.insertSelective(poor);

        Map<String, Object> map = new HashMap<>();

        if (affection == 1){
            map.put("message","添加成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",affection);
        }else {
            map.put("message","添加失败!");
            map.put("code",404);
            map.put("success",false);
            map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
        }

        return map;
    }

    @Override
    public Map<String, Object> del(Integer id) {
        int affection = poorMapper.deleteByPrimaryKey(id.longValue());
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
    public Map<String, Object> updata(Poor poor) {
        int affection = poorMapper.updateByPrimaryKey(poor);
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
    public Map<String, Object> list(Integer pageNo, Integer pageSize,String username) {
        Map<String, Object> map = new HashMap<>();

        //数据总数
        long l = poorMapper.countByExample(null);

        Map<String, Object> maps = new HashMap<>();
        maps.put( "total", l);

        if (username == null ||username.equals("")){
            PageHelper.startPage(pageNo, pageSize);
            List<PoorWithBLOBs> page = poorMapper.selectByExampleWithBLOBs(null);
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
            PoorExample poorExample = new PoorExample();

            PoorExample.Criteria criteria = poorExample.createCriteria();

            criteria.andUsernameEqualTo(username);

            List<Poor> poors = poorMapper.selectByExample(poorExample);

            maps.put("list",poors);

            if(!poors.isEmpty()){
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

    @Override
    public Map<String, Object> click(Integer id, Date clicktime) {
        Integer num = poorMapper.clickNum(id);
        if (num == null){
            num = 0;
        }
        num++;
        int affection = poorMapper.clickUp(id.longValue(),clicktime, num);
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
