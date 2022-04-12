package com.fc.dao;

import com.fc.entity.Alleviation;
import com.fc.entity.AlleviationExample;
import com.fc.entity.AlleviationWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface AlleviationMapper {
    long countByExample(AlleviationExample example);

    int deleteByExample(AlleviationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Alleviation record);

    int insertSelective(Alleviation record);

    List<AlleviationWithBLOBs> selectByExampleWithBLOBs(AlleviationExample example);

    List<Alleviation> selectByExample(AlleviationExample example);

    Alleviation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AlleviationWithBLOBs record, @Param("example") AlleviationExample example);

    int updateByExampleWithBLOBs(@Param("record") AlleviationWithBLOBs record, @Param("example") AlleviationExample example);

    int updateByExample(@Param("record") Alleviation record, @Param("example") AlleviationExample example);

    int updateByPrimaryKeySelective(AlleviationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AlleviationWithBLOBs record);

    int updateByPrimaryKey(Alleviation record);

    Integer click(@Param("id") Long id,@Param("lastClickTime") Date lastClickTime);
}