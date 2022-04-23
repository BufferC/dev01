package com.fc.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")
//@Component
// 指定注入到容器中的顺序，数值越大，优先级越低
//@Order(-1)
public class SexFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤前：只要女的");

        chain.doFilter(request, response);

        System.out.println("过滤后：很温柔~");
    }
}
