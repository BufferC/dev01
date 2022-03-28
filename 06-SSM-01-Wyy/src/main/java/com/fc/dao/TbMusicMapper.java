package com.fc.dao;

import com.fc.entity.TbMusic;
import com.fc.entity.TbMusicExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbMusicMapper {
    Integer findMaxId();

    long countByExample(TbMusicExample example);

    int deleteByExample(TbMusicExample example);

    int deleteByPrimaryKey(Integer musicId);

    int insert(TbMusic record);

    int insertSelective(TbMusic record);

    List<TbMusic> selectByExample(TbMusicExample example);

    TbMusic selectByPrimaryKey(Integer musicId);

    int updateByExampleSelective(@Param("record") TbMusic record, @Param("example") TbMusicExample example);

    int updateByExample(@Param("record") TbMusic record, @Param("example") TbMusicExample example);

    int updateByPrimaryKeySelective(TbMusic record);

    int updateByPrimaryKey(TbMusic record);
}