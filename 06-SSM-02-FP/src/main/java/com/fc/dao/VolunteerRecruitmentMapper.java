package com.fc.dao;

import com.fc.entity.VolunteerRecruitment;
import com.fc.entity.VolunteerRecruitmentExample;
import com.fc.entity.VolunteerRecruitmentWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VolunteerRecruitmentMapper {
    long countByExample(VolunteerRecruitmentExample example);

    int deleteByExample(VolunteerRecruitmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VolunteerRecruitment record);

    int insertSelective(VolunteerRecruitment record);

    List<VolunteerRecruitmentWithBLOBs> selectByExampleWithBLOBs(VolunteerRecruitmentExample example);

    List<VolunteerRecruitment> selectByExample(VolunteerRecruitmentExample example);

    VolunteerRecruitmentWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VolunteerRecruitmentWithBLOBs record, @Param("example") VolunteerRecruitmentExample example);

    int updateByExampleWithBLOBs(@Param("record") VolunteerRecruitmentWithBLOBs record, @Param("example") VolunteerRecruitmentExample example);

    int updateByExample(@Param("record") VolunteerRecruitment record, @Param("example") VolunteerRecruitmentExample example);

    int updateByPrimaryKeySelective(VolunteerRecruitmentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(VolunteerRecruitmentWithBLOBs record);

    int updateByPrimaryKey(VolunteerRecruitment record);
}