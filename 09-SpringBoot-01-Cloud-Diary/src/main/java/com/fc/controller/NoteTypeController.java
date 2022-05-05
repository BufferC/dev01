package com.fc.controller;

import com.fc.entity.TbNoteType;
import com.fc.entity.TbUser;
import com.fc.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("type")
public class NoteTypeController {
    @Autowired
    private NoteTypeService noteTypeService;

    @GetMapping("list")
    public ModelAndView list(ModelAndView mv, HttpSession session) {

        TbUser user = (TbUser) session.getAttribute("user");

        List<TbNoteType> typeList = noteTypeService.getTypes(user.getId());

        mv.addObject("list", typeList);
        mv.addObject("menu_page", "type");
        mv.addObject("changePage", "/type/list.jsp");

        mv.setViewName("forward:/index.jsp");

        return mv;
    }
}
