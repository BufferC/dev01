package com.fc.service;

import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;

import java.util.Date;
import java.util.Map;

public interface PoorService {

    Map<String, Object> add(PoorWithBLOBs poor);

    Map<String, Object> del(Integer id);

    Map<String, Object> updata(Poor poor);

    Map<String, Object> list(Integer pageNo, Integer pageSize,String username);

    Map<String, Object> click(Integer id, Date clicktime);
}
