package com.fc.dao;

import com.fc.entity.TbNote;
import com.fc.vo.NoteVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportMapper {

    List<NoteVo> getMonth(Integer id);

    List<TbNote> getLocation(Integer id);
}
