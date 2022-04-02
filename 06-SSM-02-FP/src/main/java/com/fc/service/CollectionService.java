package com.fc.service;

import com.fc.entity.Collection;

import java.util.Map;

public interface CollectionService {
    Map<String, Object> add(Collection collection);

    Map<String, Object> del(long id);

    Map<String, Object> list(Integer pageNo, Integer pageSize, Integer id);
}
