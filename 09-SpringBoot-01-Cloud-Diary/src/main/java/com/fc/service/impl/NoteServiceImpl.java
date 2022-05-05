package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.entity.TbNote;
import com.fc.service.NoteService;
import com.fc.vo.NoteVO;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private TbNoteMapper noteMapper;

    @Override
    public NoteVO getNoteById(Integer id) {
        return noteMapper.getNoteById(id);
    }

    @Override
    public ResultVO update(TbNote note) {
        ResultVO resultVO = new ResultVO();

        if (note.getPubTime() == null) {
            note.setPubTime(new Date());
        }

        int affectedRows = noteMapper.updateByPrimaryKeyWithBLOBs(note);

        if (affectedRows > 0) {
            resultVO.setCode(1);
            resultVO.setSuccess(true);
        } else {
            resultVO.setCode(0);
            resultVO.setSuccess(false);
            resultVO.setMessage("修改失败");
            resultVO.setData(note);
        }

        return resultVO;
    }

    @Override
    public ResultVO add(TbNote note) {
        ResultVO resultVO = new ResultVO();

        // 设置发布时间
        note.setPubTime(new Date());

        if (note.getLon() == null) {
            note.setLon(113.458366F);
        }

        if (note.getLat() == null) {
            note.setLat(34.772774F);
        }

        int affectedRows = noteMapper.insertSelective(note);

        if (affectedRows > 0) {
            resultVO.setCode(1);
            resultVO.setSuccess(true);
        } else {
            resultVO.setCode(0);
            resultVO.setSuccess(false);
            resultVO.setMessage("添加失败");
            resultVO.setData(note);
        }

        return resultVO;
    }

    @Override
    public ResultVO delete(Integer id) {
        ResultVO resultVO = new ResultVO();

        if (id == null) {
            resultVO.setCode(0);
            resultVO.setMessage("删除失败");
            resultVO.setSuccess(false);
        } else {
            int affectedRows = noteMapper.deleteByPrimaryKey(id);

            if (affectedRows > 0) {
                resultVO.setCode(1);
                resultVO.setSuccess(true);
                resultVO.setMessage("删除成功");
            }
        }

        return resultVO;
    }
}
