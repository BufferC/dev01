package com.fc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
// 扫描指定包路径下的接口，用于生成对应的代理对象（实现类对象）
// 全局配置，区别于@Mapper，可以指定路径下的所有接口
@MapperScan("com.fc.dao")
// 开启事务平台管理器，不用加也行，也能用
@EnableTransactionManagement
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
