package com.fc.service;

import com.fc.entity.PoorWithBLOBs;
import com.fc.vo.ResultVo;

import java.util.Date;

public interface PoorService {

    ResultVo add(PoorWithBLOBs poor);

    ResultVo del(Long id);

    ResultVo update(PoorWithBLOBs poor);

    ResultVo list(Integer pageNo, Integer pageSize,Long id);

    ResultVo click(Long id, Date clickTime);
}
