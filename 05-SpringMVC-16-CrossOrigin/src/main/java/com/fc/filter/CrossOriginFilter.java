package com.fc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrossOriginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        // 强转为支持HTTP协议的响应对象
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // *代表跨所有域
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        //httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
        //httpServletResponse.setHeader("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS");
        //httpServletResponse.setHeader("Access-Control-Max-Age", "3600");

        // 获取请求源
        String origin = httpServletRequest.getHeader("Origin");

        System.out.println("请求源是：" + origin);

        chain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
