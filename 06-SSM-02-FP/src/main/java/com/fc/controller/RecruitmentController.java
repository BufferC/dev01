package com.fc.controller;

import com.fc.entity.VolunteerRecruitment;
import com.fc.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("recruitment")
public class RecruitmentController {
    @Autowired
    private RecruitmentService recruitmentService;

    @RequestMapping("add")
    public Map<String,Object> add(VolunteerRecruitment volunteerRecruitment){
        return recruitmentService.add(volunteerRecruitment);
    }

    @RequestMapping("del")
    public Map<String,Object> del(Integer id){
        return recruitmentService.del(id);
    }

    @RequestMapping("updata")
    public Map<String,Object> updata(VolunteerRecruitment volunteerRecruitment){
        return recruitmentService.updata(volunteerRecruitment);
    }

    @RequestMapping("list")
    public Map<String,Object> list(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        return recruitmentService.list(pageNo,pageSize);
    }

    @RequestMapping("click")
    public Map<String,Object> click(Integer id, Date clicktime){
        return recruitmentService.click(id,clicktime);
    }
}
