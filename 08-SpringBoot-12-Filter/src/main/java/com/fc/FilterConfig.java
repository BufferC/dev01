package com.fc;

import com.fc.filter.RichFilter;
import com.fc.filter.SexFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<Filter> sexFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        // 设置过滤器
        bean.setFilter(new SexFilter());
        // 设置优先级
        bean.setOrder(-10000);

        Collection<String> set = new HashSet<>();
        set.add("/*");

        // 设置过滤的路径
        bean.setUrlPatterns(set);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<Filter> richFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        // 设置过滤器
        bean.setFilter(new RichFilter());
        // 设置优先级
        bean.setOrder(10000);

        // 设置过滤的路径
        bean.setUrlPatterns(Collections.singletonList("/test/filter"));
        return bean;
    }
}
