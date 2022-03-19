package com.fc.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.fc.dao.AccountDao;
import com.fc.dao.LocationDao;
import com.fc.dao.impl.AccountDaoImpl;
import com.fc.dao.impl.LocationDaoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

// 将指定路径下的配置文件加载进来
@PropertySource("classpath:jdbc.properties")
@ComponentScan("com.fc")
// 声明了此注解，说明当前类是一个配置类，替换掉配置文件
@Configuration
@EnableTransactionManagement
public class TxtConfig {
    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    // @Bean注解用于将当前方法的返回值放到容器中
    @Bean
    public DataSource dataSource() {
        Properties properties = new Properties();

        properties.setProperty("driverClassName", driverClassName);
        properties.setProperty("url", url);
        properties.setProperty("username", username);
        properties.setProperty("password", password);

        DataSource dataSource = null;

        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSource;
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public AccountDao accountDao(DataSource dataSource) {
        AccountDaoImpl accountDao = new AccountDaoImpl();

        accountDao.setDataSource(dataSource);

        return accountDao;
    }

    @Bean
    public LocationDao locationDao(DataSource dataSource) {
        LocationDaoImpl locationDao = new LocationDaoImpl();

        locationDao.setDataSource(dataSource);

        return locationDao;
    }
}
