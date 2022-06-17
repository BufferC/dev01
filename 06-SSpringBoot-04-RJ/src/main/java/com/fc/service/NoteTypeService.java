package com.fc.service;

import com.fc.entity.TbNoteType;
import com.fc.vo.ResultVo;

import java.util.List;

public interface NoteTypeService {
    List<TbNoteType> selectTypeById(Integer id);

    ResultVo add(String typeName, Integer id);

    ResultVo update(TbNoteType noteType);

    int delete(Integer id);
}
