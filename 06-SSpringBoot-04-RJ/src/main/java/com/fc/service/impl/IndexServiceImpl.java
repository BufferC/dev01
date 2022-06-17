package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.entity.TbNote;
import com.fc.service.IndexService;
import com.fc.vo.NoteVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private TbNoteMapper  tbNoteDao;
    @Override
    public PageInfo<TbNote> page(Integer userId, Integer id, String title, String date, Integer pageNum, Integer pageSize) {
        // 准备模糊查询的条件
        if (title != null && title.equals("")){
            title = "%" + title +"%";
        }

        PageHelper.startPage(pageNum,pageSize);

        List<TbNote> list = tbNoteDao.selectUserPageAll(userId,id,title,date);
        return new PageInfo<>(list);
    }

    @Override
    public List<NoteVo> timeType(Integer userId) {
        return tbNoteDao.selectTimeType(userId);
    }

    @Override
    public List<NoteVo> DateInfo(Integer userId) {
        return tbNoteDao.selectDateType(userId);
    }
}
