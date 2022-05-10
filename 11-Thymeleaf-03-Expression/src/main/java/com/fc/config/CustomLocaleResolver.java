package com.fc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

// 这个名字必须和前端控制器中的组件名保持一致
@Configuration("localeResolver")
public class CustomLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");

        Locale locale;

        // 说明没有传递国际化语言
        if (lang == null || lang.equals("")) {
            locale = new Locale("zh", "CN");
        } else {
            String[] array = lang.split("_");

            locale = new Locale(array[0], array[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }
}
