package com.fc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//生产者
@SpringBootApplication
//@EnableDiscoveryClient和@EnableEurekaClient共同点就是：都是能够让注册中心能够发现，扫描到改服务。
@EnableEurekaClient//只适用于Eureka作为注册中心
@EnableDiscoveryClient//可以是其他注册中心
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
