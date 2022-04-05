package com.fc.service;

import com.fc.entity.VolunteerRecruitment;

import java.util.Date;
import java.util.Map;

public interface RecruitmentService {
    Map<String, Object> add(VolunteerRecruitment volunteerRecruitment);

    Map<String, Object> del(Integer id);

    Map<String, Object> updata(VolunteerRecruitment volunteerRecruitment);

    Map<String, Object> list(Integer pageNo, Integer pageSize);

    Map<String, Object> click(Integer id, Date clicktime);
}
