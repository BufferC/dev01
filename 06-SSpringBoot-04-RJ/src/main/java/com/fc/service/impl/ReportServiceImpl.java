package com.fc.service.impl;

import com.fc.dao.ReportMapper;
import com.fc.entity.TbNote;
import com.fc.service.ReportService;
import com.fc.vo.NoteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportDao;
    @Override
    public Map<String, Object> getMonth(Integer id) {
        Map<String, Object> map = new HashMap<>();
        List<NoteVo> list = reportDao.getMonth(id);

        if (list != null && list.size()>0){
            List<String> months = new ArrayList<>();
            List<Integer> counts = new ArrayList<>();
            for (NoteVo nv :list) {
                months.add(nv.getGroupName());
                counts.add(nv.getNoteCount());
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
