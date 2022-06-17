package com.fc.service;

import com.fc.entity.TbNote;
import com.fc.vo.NoteVo;
import com.fc.vo.ResultVo;

public interface NoteService {

    ResultVo update(TbNote note);

    ResultVo add(TbNote note);

    NoteVo getNoteById(Integer id);

    ResultVo delete(Integer id);
}
