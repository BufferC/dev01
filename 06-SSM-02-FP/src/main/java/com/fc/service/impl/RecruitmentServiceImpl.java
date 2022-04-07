package com.fc.service.impl;

import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.RecruitmentService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;
    @Override
    public ResultVo add(VolunteerRecruitment volunteerRecruitment) {
        if (volunteerRecruitment.getCreateTime() == null){
            volunteerRecruitment.setCreateTime(new Date());
        }
        ResultVo resultVo;
        int affection = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);
        if (affection == 1){
            resultVo = new ResultVo("添加成功!",affection,true,200);
        }else {
            resultVo = new ResultVo("添加失败!",null,false,404);
        }
        return resultVo;
    }

    @Override
    public ResultVo del(Long id) {
        ResultVo resultVo;
        int affection = volunteerRecruitmentMapper.deleteByPrimaryKey(id);
        if (affection == 1){
            resultVo = new ResultVo("删除成功!",affection,true,200);
        }else {
            resultVo = new ResultVo("删除失败!",null,false,404);
        }
        return resultVo;
    }

    @Override
    public ResultVo update(VolunteerRecruitment volunteerRecruitment) {
        ResultVo resultVo;
        int affection = volunteerRecruitmentMapper.updateByPrimaryKeySelective(volunteerRecruitment);
        if (affection == 1){
            resultVo = new ResultVo("修改成功!",volunteerRecruitmentMapper.selectByPrimaryKey(volunteerRecruitment.getId()),true,200);
        }else {
            resultVo = new ResultVo("修改失败!", null, false, 404);
        }
        return resultVo;
    }

    @Override
    public ResultVo list(Integer pageNo, Integer pageSize,Long id) {
        List<VolunteerRecruitment> arrayList;
        PageInfo<VolunteerRecruitment> vPageInfo;
        ResultVo resultVo ;

        try {
            if (id == null){
                PageHelper.startPage(pageNo, pageSize);
                arrayList = volunteerRecruitmentMapper.selectByExample(null);
            }else {
                arrayList = new ArrayList<>();
                arrayList.add(volunteerRecruitmentMapper.selectByPrimaryKey(id));
            }
            //DataVo<Object> dataVo = new DataVo<>();
            vPageInfo = new PageInfo<>(arrayList);
            resultVo = new ResultVo("获取成功!",vPageInfo,true,200);
        }catch (Exception e){
            resultVo = new ResultVo("获取失败!",null,false,404);
        }

        return resultVo;
    }
}
