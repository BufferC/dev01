package com.fc.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.entity.TbUser;
import com.fc.vo.ResultVo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        TbUser user = (TbUser)session.getAttribute("user");
        ResultVo vo;
        if (user == null){
            vo = new ResultVo(404,"请登录，再访问",false,null);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vo);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(json);
            response.sendRedirect("http://localhost:8080/login.jsp");
        }else {
            // 放行
            System.out.println(user);
            return true;
        }

        return false;
    }
}
