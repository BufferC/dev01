package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.entity.TbNote;
import com.fc.service.IndexService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private TbNoteMapper noteDao;

    @Override
    public PageInfo<TbNote> page(Integer pageNum, Integer pageSize, Integer userId, Integer id, String title, String date) {
        // 准备模糊查询的条件
        if (title != null) {
            title = "%" + title + "%";
        }

        // 开启分页
        PageHelper.startPage(pageNum, pageSize);

        List<TbNote> notes = noteDao.findByPageAndUserId(userId, id, title, date);

        return new PageInfo<>(notes);
    }
}
