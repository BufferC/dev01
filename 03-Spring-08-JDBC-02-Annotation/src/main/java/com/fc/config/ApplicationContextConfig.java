package com.fc.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

// 将指定路径下的配置文件加载进来
@PropertySource("classpath:jdbc.properties")
@ComponentScan("com.fc")
// 声明了此注解，说明当前类是一个配置类，替换掉配置文件
@Configuration
public class ApplicationContextConfig {
    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    // @Bean注解用于将当前方法的返回值放到容器中
    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = null;

        try {
            Properties properties = new Properties();

            properties.setProperty("driverClassName", driverClassName);
            properties.setProperty("url", url);
            properties.setProperty("username", username);
            properties.setProperty("password", password);

            DataSource dataSource;

            dataSource = DruidDataSourceFactory.createDataSource(properties);

            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jdbcTemplate;
    }
}
