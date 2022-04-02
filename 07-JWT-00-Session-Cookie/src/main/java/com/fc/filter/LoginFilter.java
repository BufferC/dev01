package com.fc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // 获取请求URL中的路径部分
        String uri = httpServletRequest.getRequestURI();

        HttpSession session = httpServletRequest.getSession(false);

        // 如果要登录
        if (uri.endsWith("login") || uri.endsWith("login.jsp")) {
            chain.doFilter(httpServletRequest, httpServletResponse);
        } else if (session == null) {
            httpServletResponse.sendRedirect("/login.jsp");
        } else if (session.getAttribute("username") != null) {
            chain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            httpServletResponse.sendRedirect("/login.jsp");
        }
    }

    @Override
    public void destroy() {
    }
}
