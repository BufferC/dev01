package com.fc.service;

import com.fc.entity.AlleviationWithBLOBs;
import com.fc.vo.ResultVo;

import java.util.Date;

public interface AlleviationService {
    ResultVo add(AlleviationWithBLOBs alleviation);

    ResultVo update(AlleviationWithBLOBs alleviation);

    ResultVo del(Long id);

    ResultVo list(Integer pageNo, Integer pageSize,String type);

    ResultVo click(Long id, Date lastClickTime);

}
