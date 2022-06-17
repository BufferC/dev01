package com.fc.controller;

import com.fc.entity.TbNote;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbUser;
import com.fc.service.NoteService;
import com.fc.service.NoteTypeService;
import com.fc.vo.NoteVo;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteTypeService noteTypeService;

    @PostMapping("addOrUpdate")
    public ModelAndView addOrUpdate(TbNote note, ModelAndView mv){
        mv.addObject("menu_page", "note");

        ResultVo vo;

        // 如果日记id不为空，就执行修改
        if (note.getId() != null) {
            vo = noteService.update(note);
        }else {
            vo = noteService.add(note);
        }

        if (vo.getCode() == 1) {
            // 注意，这里要使用重定向
            mv.setViewName("redirect:/index/page");
        } else {
            mv.addObject("resultInfo", vo);
            mv.addObject("id", note.getId());
            mv.setViewName("forward:/note/view");
        }

        return mv;
    }

    @GetMapping("view")
    public ModelAndView view(Integer id, ModelAndView mv, HttpSession session){
        // 如果存在id，就根据id进行查询日记
        NoteVo vo = noteService.getNoteById(id);
        mv.addObject("noteInfo", vo);
        TbUser user = (TbUser) session.getAttribute("user");
        // 根据用户id获取所有的分类
        List<TbNoteType> types = noteTypeService.selectTypeById(user.getId());
        mv.addObject("typeList", types);
        mv.addObject("changePage", "/note/view.jsp");
        mv.addObject("menu_page", "note");

        mv.setViewName("forward:/index.jsp");
        return mv;
    }
    @GetMapping("detail")
    public ModelAndView getNoteById(Integer id, ModelAndView mv) {

        NoteVo vo = noteService.getNoteById(id);

        mv.addObject("note", vo);
        mv.addObject("changePage", "/note/detail.jsp");
        mv.addObject("menu_page", "note");

        mv.setViewName("forward:/index.jsp");

        return mv;
    }

    @GetMapping("delete")
    @ResponseBody
    public ResultVo delete(@RequestParam Integer id) {
        return noteService.delete(id);
    }
}
