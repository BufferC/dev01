package com.fc.dao;

import com.fc.entity.TbNote;
import com.fc.vo.NoteVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao {
    List<NoteVO> getMonth(Integer id);

    List<TbNote> getLocation(Integer id);
}
