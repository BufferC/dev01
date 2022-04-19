package com.fc.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

// 自定义的环境处理类
public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // 自定义配置文件
        String[] profiles = {"jdbc.properties", "student.yml"};

        // 获取每一个文件名
        for (String profile : profiles) {
            // 把配置文件转为Resource
            Resource resource = new ClassPathResource(profile);

            Properties properties;

            // 如果配置文件是properties文件
            if (profile.contains("properties")) {
                properties = new Properties();

                try {
                    properties.load(resource.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 否则就是yml文件
            } else {
                YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();

                factoryBean.setResources(resource);

                properties = factoryBean.getObject();
            }

            PropertiesPropertySource propertySource = new PropertiesPropertySource(profile, properties);

            environment.getPropertySources().addLast(propertySource);
        }
    }
}
