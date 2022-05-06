package com.fc.service;

import com.fc.entity.TbNoteType;
import com.fc.vo.ResultVO;

import java.util.List;

public interface NoteTypeService {
    List<TbNoteType> getTypes(Integer id);

    ResultVO add(String typeName, Integer userId);

    ResultVO update(TbNoteType noteType);

    int delete(Integer id);
}
