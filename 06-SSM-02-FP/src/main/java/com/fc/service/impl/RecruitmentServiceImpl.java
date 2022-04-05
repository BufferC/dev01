package com.fc.service.impl;

import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.RecruitmentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;
    @Override
    public Map<String, Object> add(VolunteerRecruitment volunteerRecruitment) {
        int affection = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);

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
        int affection = volunteerRecruitmentMapper.deleteByPrimaryKey(id.longValue());
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
    public Map<String, Object> updata(VolunteerRecruitment volunteerRecruitment) {
        int affection = volunteerRecruitmentMapper.updateByPrimaryKey(volunteerRecruitment);
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
    public Map<String, Object> list(Integer pageNo, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();

        //数据总数
        long l = volunteerRecruitmentMapper.countByExample(null);

        Map<String, Object> maps = new HashMap<>();
        maps.put( "total", l);

        PageHelper.startPage(pageNo, pageSize);
        List<VolunteerRecruitment> page = volunteerRecruitmentMapper.selectByExample(null);
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
        Integer num = volunteerRecruitmentMapper.clickNum(id);
        if (num == null){
            num = 0;
        }
        num++;
        int affection = volunteerRecruitmentMapper.clickUp(id.longValue(),clicktime, num);
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
