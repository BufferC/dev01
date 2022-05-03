package com.fc.service.impl;

import com.fc.dao.ReportDao;
import com.fc.entity.TbNote;
import com.fc.service.ReportService;
import com.fc.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportDao reportDao;

    @Override
    public Map<String, Object> getMonth(Integer id) {

        Map<String, Object> map = new HashMap<>();

        List<NoteVO> notes = reportDao.getMonth(id);

        if (notes != null && notes.size() > 0) {
            List<String> months = new ArrayList<>();
            List<Integer> counts = new ArrayList<>();

            for (NoteVO note : notes) {
                months.add(note.getGroupName());
                counts.add(note.getNoteCount());
            }

            map.put("monthArray", months);
            map.put("dataArray", counts);
        }

        return map;
    }

    @Override
    public List<TbNote> getLocation(Integer id) {
        return reportDao.getLocation(id);
    }
}
