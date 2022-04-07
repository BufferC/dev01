package com.fc.service;

import com.fc.entity.VolunteerRecruitment;
import com.fc.vo.ResultVo;

public interface RecruitmentService {
    ResultVo add(VolunteerRecruitment volunteerRecruitment);

    ResultVo del(Long id);

    ResultVo update(VolunteerRecruitment volunteerRecruitment);

    ResultVo list(Integer pageNo, Integer pageSize,Long id);
}
