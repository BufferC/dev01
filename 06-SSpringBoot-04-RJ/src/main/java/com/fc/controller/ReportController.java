package com.fc.controller;

import com.fc.entity.TbNote;
import com.fc.entity.TbUser;
import com.fc.service.ReportService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("info")
    public ModelAndView toInfo(ModelAndView mv) {

        mv.addObject("menu_page", "report");
        mv.addObject("changePage", "/report/info.jsp");
        mv.setViewName("forward:/index.jsp");
        return mv;
    }

    @GetMapping("month")
    @ResponseBody
    public ResultVo getMonth(HttpSession session) {
        TbUser user = (TbUser) session.getAttribute("user");

        Map<String, Object> data = reportService.getMonth(user.getId());

        ResultVo vo = new ResultVo();

        if (data != null) {
            vo.setData(data);
            vo.setCode(1);
        }

        return vo;
    }

    @GetMapping("location")
    @ResponseBody
    public ResultVo getLocation(HttpSession session) {
        TbUser user = (TbUser) session.getAttribute("user");

        List<TbNote> notes = reportService.getLocation(user.getId());

        ResultVo vo = new ResultVo();

        if (notes != null && notes.size() > 0) {
            vo.setCode(1);
            vo.setSuccess(true);
            vo.setData(notes);
        }

        return vo;
    }
}
