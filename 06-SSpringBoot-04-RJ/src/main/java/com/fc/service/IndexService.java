package com.fc.service;

import com.fc.entity.TbNote;
import com.fc.vo.NoteVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IndexService {
    PageInfo<TbNote> page(Integer userId, Integer id, String title, String date, Integer pageNum, Integer pageSize);

    List<NoteVo> timeType(Integer userId);

    List<NoteVo> DateInfo(Integer userId);
}
