package com.fc.service;

import com.fc.entity.Alleviation;
import com.fc.vo.ResultVo;

import java.util.Date;

public interface AlleviationService {
    ResultVo add(Alleviation alleviation);

    ResultVo update(Alleviation alleviation);

    ResultVo del(Long id);

    ResultVo list(Integer pageNo, Integer pageSize);

    ResultVo click(Long id, Date lastClickTime);
}
