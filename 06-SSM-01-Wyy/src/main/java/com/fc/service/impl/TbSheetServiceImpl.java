package com.fc.service.impl;

import com.fc.dao.TbSheetMapper;
import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;
import com.fc.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbSheetServiceImpl implements TbSheetService {
    @Autowired
    private TbSheetMapper sheetMapper;

    @Override
    public List<TbSheet> findAll() {
        return sheetMapper.selectByExample(null);
    }

    @Override
    public List<TbMusic> findSongsBySheet(String sheetName) {
        return sheetMapper.findSongsBySheet(sheetName);
    }

    @Override
    public int insertSheet(TbSheet tbSheet) {
        return sheetMapper.insertSelective(tbSheet);
    }
}
