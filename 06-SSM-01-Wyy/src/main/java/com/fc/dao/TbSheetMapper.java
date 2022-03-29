package com.fc.dao;

import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;
import com.fc.entity.TbSheetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSheetMapper {
    List<TbMusic> findSongsBySheet(@Param("sheetName") String sheetName);

    long countByExample(TbSheetExample example);

    int deleteByExample(TbSheetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSheet record);

    int insertSelective(TbSheet record);

    List<TbSheet> selectByExample(TbSheetExample example);

    TbSheet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSheet record, @Param("example") TbSheetExample example);

    int updateByExample(@Param("record") TbSheet record, @Param("example") TbSheetExample example);

    int updateByPrimaryKeySelective(TbSheet record);

    int updateByPrimaryKey(TbSheet record);
}