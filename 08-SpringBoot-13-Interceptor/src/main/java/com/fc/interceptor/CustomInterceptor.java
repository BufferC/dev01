package com.fc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 自定义拦截器
public class CustomInterceptor implements HandlerInterceptor {
    /**
     * 控制器执行之前执行此方法
     * @return 如果true，就放行，如果是false就被拦截下来了，后续的方法就不执行了
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle be called ~");

        return false;
    }

    // 控制器执行之后执行此方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle be called ~");
    }

    // 页面渲染完成之后执行此方法，常用于资源释放
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion be called ~");
    }
}
