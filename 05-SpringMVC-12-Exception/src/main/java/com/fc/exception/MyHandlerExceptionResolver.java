package com.fc.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();

        if (ex instanceof MyException) {
            modelAndView.addObject("message", "自定义异常");
        } else {
            modelAndView.addObject("message", ex.getMessage());
        }

        modelAndView.setViewName("/error.jsp");

        return modelAndView;
    }
}
