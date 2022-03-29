package com.fc.service;

import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;

import java.util.List;

public interface TbSheetService {
    List<TbSheet> findAll();

    List<TbMusic> findSongsBySheet(String sheetName);

    int insertSheet(TbSheet tbSheet);
}
