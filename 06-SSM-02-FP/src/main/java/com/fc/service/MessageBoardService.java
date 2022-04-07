package com.fc.service;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.vo.ResultVo;

public interface MessageBoardService {
    ResultVo add(MessageBoardWithBLOBs messageBoard);

    ResultVo del(Long id);

    ResultVo list(Integer pageNo, Integer pageSize, Long id);

    ResultVo reply(MessageBoardWithBLOBs messageBoardWithBLOBs, String isDel);
}
