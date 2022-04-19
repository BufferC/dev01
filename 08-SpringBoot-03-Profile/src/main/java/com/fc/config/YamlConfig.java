package com.fc.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

// 自定义yml的环境配置
//@Configuration
public class YamlConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();

        // 获取Yaml属性的FactoryBean
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();

        // 将配置文件变成Resource
        Resource resource = new ClassPathResource("student.yml");

        // 设置资源
        factoryBean.setResources(resource);

        // 获取Properties对象
        Properties properties = factoryBean.getObject();

        configurer.setProperties(properties);

        return configurer;
    }
}
