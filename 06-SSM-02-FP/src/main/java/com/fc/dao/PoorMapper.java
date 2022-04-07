package com.fc.dao;

import com.fc.entity.Poor;
import com.fc.entity.PoorExample;
import com.fc.entity.PoorWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface PoorMapper {
    long countByExample(PoorExample example);

    int deleteByExample(PoorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PoorWithBLOBs record);

    int insertSelective(PoorWithBLOBs record);

    List<PoorWithBLOBs> selectByExampleWithBLOBs(PoorExample example);

    List<Poor> selectByExample(PoorExample example);

    PoorWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PoorWithBLOBs record, @Param("example") PoorExample example);

    int updateByExampleWithBLOBs(@Param("record") PoorWithBLOBs record, @Param("example") PoorExample example);

    int updateByExample(@Param("record") Poor record, @Param("example") PoorExample example);

    int updateByPrimaryKeySelective(PoorWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PoorWithBLOBs record);

    int updateByPrimaryKey(Poor record);

    Integer click(@Param("id") Long id,@Param("lastClickTime") Date lastClickTime);
}