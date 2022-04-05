package com.fc.dao;

import com.fc.entity.Alleviation;
import com.fc.entity.AlleviationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface AlleviationMapper {
    Integer clickNum(Integer id);

    int clickUp(@Param("id") long id, @Param("lastClickTime") Date lastClickTime, @Param("clickNum") Integer clickNum);

    long countByExample(AlleviationExample example);

    int deleteByExample(AlleviationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Alleviation record);

    int insertSelective(Alleviation record);

    List<Alleviation> selectByExampleWithBLOBs(AlleviationExample example);

    List<Alleviation> selectByExample(AlleviationExample example);

    Alleviation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Alleviation record, @Param("example") AlleviationExample example);

    int updateByExampleWithBLOBs(@Param("record") Alleviation record, @Param("example") AlleviationExample example);

    int updateByExample(@Param("record") Alleviation record, @Param("example") AlleviationExample example);

    int updateByPrimaryKeySelective(Alleviation record);

    int updateByPrimaryKeyWithBLOBs(Alleviation record);

    int updateByPrimaryKey(Alleviation record);
}