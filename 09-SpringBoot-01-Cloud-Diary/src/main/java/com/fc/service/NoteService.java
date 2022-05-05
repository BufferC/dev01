package com.fc.service;

import com.fc.entity.TbNote;
import com.fc.vo.NoteVO;
import com.fc.vo.ResultVO;

public interface NoteService {
    NoteVO getNoteById(Integer id);

    ResultVO update(TbNote note);

    ResultVO add(TbNote note);

    ResultVO delete(Integer id);
}
