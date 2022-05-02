package com.fc.controller;

import com.fc.entity.TbNote;
import com.fc.entity.TbUser;
import com.fc.service.IndexService;
import com.fc.vo.NoteVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("index")
public class IndexController {
    @Autowired
    private IndexService indexService;

    /**
     *
     * @param id typeId 日记类型id
     * @param title 日记的标题
     * @param date 日期
     */
    @RequestMapping(value = "page", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView page(Integer id,
                             String title,
                             String date,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             HttpSession session,
                             ModelAndView mv) {
        // 获取域对象中的user
        TbUser user = (TbUser) session.getAttribute("user");

        // 获取用户id
        Integer userId = user.getId();

        // 所有的日记
        PageInfo<TbNote> pageInfo = indexService.page(pageNum, pageSize, userId, id, title, date);
        mv.addObject("page", pageInfo);

        // 获取所有日记的日期分类
        List<NoteVO> dateInfo = indexService.findDateInfo(userId);

        mv.addObject("dateInfo", dateInfo);

        // 获取所有日记的类别
        List<NoteVO> typeInfo = indexService.findTypeInfo(userId);
        mv.addObject("typeInfo", typeInfo);


        mv.addObject("changePage", "/note/list.jsp");

        mv.setViewName("forward:/index.jsp");

        return mv;
    }
}
