package com.fc.service;

import com.fc.entity.TbNoteType;

import java.util.List;

public interface NoteTypeService {
    List<TbNoteType> getTypes(Integer id);
}
