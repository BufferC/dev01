package com.fc.controller;

import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ModelAndView login(TbUser user,
                              Integer remember,
                              HttpSession session,
                              HttpServletResponse response,
                              ModelAndView mv) {

        // 调用业务层的登录方法
        ResultVO result = userService.login(user.getUsername(), user.getPassword());

        // 登录成功的情况
        if (result.getCode() == 200) {

            session.setAttribute("user", result.getData());

            Cookie cookie;

            // 勾选了记住我
            if (remember != null && remember == 1 ) {
                cookie = new Cookie("JSESSIONID", session.getId());

                // 半个钟头
                cookie.setMaxAge(30 * 60);
            } else {
                cookie = new Cookie("JSESSIONID", null);

                // 浏览器关闭时自动销毁
                cookie.setMaxAge(-1);
            }

            // 发送到浏览器
            response.addCookie(cookie);

            mv.setViewName("/index.jsp");
        } else {
            // 登录失败的情况
            mv.addObject("resultInfo", result);
            mv.setViewName("redirect:/login.jsp");
        }

        return mv;
    }
}
