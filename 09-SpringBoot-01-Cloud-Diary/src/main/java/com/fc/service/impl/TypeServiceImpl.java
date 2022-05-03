package com.fc.service.impl;

import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbNoteTypeExample;
import com.fc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TbNoteTypeMapper typeMapper;

    @Override
    public List<TbNoteType> getTypes(Integer id) {
        TbNoteTypeExample example = new TbNoteTypeExample();

        TbNoteTypeExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(id);

        return typeMapper.selectByExample(example);
    }
}
