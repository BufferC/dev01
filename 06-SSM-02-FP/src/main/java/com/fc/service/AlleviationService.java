package com.fc.service;

import com.fc.entity.Alleviation;

import java.util.Date;
import java.util.Map;

public interface AlleviationService {
    Map<String, Object> add(Alleviation alleviation);

    Map<String, Object> updata(Alleviation alleviation);

    Map<String, Object> del(Integer id);

    Map<String, Object> list(Integer pageNo, Integer pageSize);

    Map<String, Object> click(Integer id, Date clicktime);
}
