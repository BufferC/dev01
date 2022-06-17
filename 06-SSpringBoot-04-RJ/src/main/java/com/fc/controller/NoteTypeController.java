package com.fc.controller;

import com.fc.entity.TbNoteType;
import com.fc.entity.TbUser;
import com.fc.service.NoteTypeService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

        List<TbNoteType> typeList = noteTypeService.selectTypeById(user.getId());

        mv.addObject("list", typeList);
        mv.addObject("menu_page", "type");
        mv.addObject("changePage", "/type/list.jsp");

        mv.setViewName("forward:/index.jsp");

        return mv;
    }

    @PostMapping("addOrUpdate")
    @ResponseBody
    public ResultVo addOrUpdate(TbNoteType noteType, HttpSession session) {
        ResultVo vo;

        TbUser user = (TbUser) session.getAttribute("user");

        // 没有id说明执行的添加操作
        if (noteType.getId() == null) {
            vo = noteTypeService.add(noteType.getTypeName(), user.getId());
        } else {
            // 有id说明是修改操作
            vo = noteTypeService.update(noteType);
        }

        return vo;
    }

    @GetMapping("delete")
    @ResponseBody
    public ResultVo delete(@RequestParam Integer id) {
        int affectedRows = noteTypeService.delete(id);

        ResultVo vo = new ResultVo();

        if (affectedRows > 0) {
            vo.setCode(1);
            vo.setMessage("删除成功！");
        } else {
            vo.setCode(0);
            vo.setMessage("删除失败！！！");
        }

        return vo;
    }
}
