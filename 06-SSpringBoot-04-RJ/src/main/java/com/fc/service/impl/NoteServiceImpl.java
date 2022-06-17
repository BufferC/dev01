package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.entity.TbNote;
import com.fc.service.NoteService;
import com.fc.vo.NoteVo;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private TbNoteMapper tbNoteDao;
    @Override
    public ResultVo update(TbNote note) {
        ResultVo vo = new ResultVo();
        if (note.getPubTime() == null) {
            note.setPubTime(new Date());
        }

        int affected = tbNoteDao.updateByPrimaryKeyWithBLOBs(note);
        if (affected > 0) {
            vo.setCode(1);
            vo.setSuccess(true);
        } else {
            vo.setCode(0);
            vo.setSuccess(false);
            vo.setMessage("修改失败");
            vo.setData(note);
        }

        return vo;
    }

    @Override
    public ResultVo add(TbNote note) {
        ResultVo vo = new ResultVo();
        // 设置发布时间
        note.setPubTime(new Date());

        if (note.getLon() == null) {
            note.setLon(113.458366F);
        }

        if (note.getLat() == null) {
            note.setLat(34.772774F);
        }

        int affected = tbNoteDao.insertSelective(note);
        if (affected > 0) {
            vo.setCode(1);
            vo.setSuccess(true);
        } else {
            vo.setCode(0);
            vo.setSuccess(false);
            vo.setMessage("添加失败");
            vo.setData(note);
        }

        return vo;
    }

    @Override
    public NoteVo getNoteById(Integer id) {
        return tbNoteDao.getNoteById(id);
    }

    @Override
    public ResultVo delete(Integer id) {
        ResultVo vo = new ResultVo();
        if (id == null) {
            vo.setCode(0);
            vo.setMessage("删除失败");
            vo.setSuccess(false);
        } else {
            int affected = tbNoteDao.deleteByPrimaryKey(id);
            if (affected > 0) {
                vo.setCode(1);
                vo.setSuccess(true);
                vo.setMessage("删除成功");
            }
        }
        return vo;
    }
}
