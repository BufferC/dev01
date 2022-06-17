package com.fc.service;

import com.fc.entity.VolunteerRecruitmentWithBLOBs;
import com.fc.vo.ResultVo;

public interface RecruitmentService {
    ResultVo add(VolunteerRecruitmentWithBLOBs volunteerRecruitment);

    ResultVo del(Long id);

    ResultVo update(VolunteerRecruitmentWithBLOBs volunteerRecruitment);

    ResultVo list(Integer pageNo, Integer pageSize,String position);
}
