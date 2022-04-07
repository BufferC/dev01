package com.fc.controller;

import com.fc.entity.VolunteerRecruitment;
import com.fc.service.RecruitmentService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("recruitment")
public class RecruitmentController {
    @Autowired
    private RecruitmentService recruitmentService;

    @RequestMapping("add")
    public ResultVo add(VolunteerRecruitment volunteerRecruitment){
        return recruitmentService.add(volunteerRecruitment);
    }

    @RequestMapping("del")
    public ResultVo del(Long id){
        return recruitmentService.del(id);
    }

    @RequestMapping("update")
    public ResultVo updata(VolunteerRecruitment volunteerRecruitment){
        return recruitmentService.update(volunteerRecruitment);
    }

    @RequestMapping("list")
    public ResultVo list(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,Long id){
        return recruitmentService.list(pageNo,pageSize,id);
    }

}
