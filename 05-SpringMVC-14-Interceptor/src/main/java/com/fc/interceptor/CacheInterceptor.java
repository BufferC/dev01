package com.fc.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.vo.ResultVO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class CacheInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("查询缓存....：");

        HttpSession session = request.getSession(false);
        // 第一次访问，直接放行
        if (session == null) {
            return true;
        }

        Object foods = session.getAttribute("foods");

        // 第一次访问控制器，直接放行
        if (foods == null) {
            return true;
        }

        // 设置响应数据的类型
        response.setContentType("application/json; charset=UTF-8");

        // 创建视图对象
        ResultVO vo = new ResultVO(2012, "查到了缓存", true, foods);

        // 解析成json字符串
        String json = new ObjectMapper().writeValueAsString(vo);

        // 写数据到页面上
        response.getWriter().write(json);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            Map<String, Object> map = modelAndView.getModel();

            Object foods = map.get("foods");

            request.getSession(true).setAttribute("foods", foods);

            System.out.println("存到缓存中...");

            // 设置响应数据的类型
            response.setContentType("application/json; charset=UTF-8");

            // 创建视图对象
            ResultVO vo = new ResultVO(205, "没有查到缓存", true, foods);

            // 解析成json字符串
            String json = new ObjectMapper().writeValueAsString(vo);

            // 写数据到页面上
            response.getWriter().write(json);
        }
    }
}
