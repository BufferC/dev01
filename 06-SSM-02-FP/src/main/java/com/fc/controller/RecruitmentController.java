package com.fc.controller;

import com.fc.entity.VolunteerRecruitmentWithBLOBs;
import com.fc.service.RecruitmentService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("volunteer")
public class RecruitmentController {
    @Autowired
    private RecruitmentService recruitmentService;

    @RequestMapping("add")
    public ResultVo add(@RequestBody VolunteerRecruitmentWithBLOBs volunteerRecruitment){
        return recruitmentService.add(volunteerRecruitment);
    }

    @RequestMapping("delete")
    public ResultVo del(Long id){
        return recruitmentService.del(id);
    }

    @RequestMapping("update")
    public ResultVo updata(@RequestBody VolunteerRecruitmentWithBLOBs volunteerRecruitment){
        return recruitmentService.update(volunteerRecruitment);
    }

    @RequestMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,@RequestParam(value = "position",required = false)String position){
        return recruitmentService.list(pageNum,pageSize,position);
    }

}
