package com.fc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//获取注册进来的微服务信息
@RestController
public class BlogController {

    //获取端口号
    @Value("${server.port}")
    private Integer port;

    /**
     * DiscoveryClient 可以用来获取一些配置的信息，得到具体的微服务！
     */
    @Autowired
    private DiscoveryClient client;

    @GetMapping("/getPort")
    public Integer getTodayFinishOrderNum() {
        return port;
    }

    //注册进来的微服务，获取一些消息
    @GetMapping("/blog/discovery")
    public Object discovery() {
        //获取微服务列表清单
        List<String> services = client.getServices();
        System.out.println("discovery => services: " + services);

        //得到一个具体的微服务信息
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-BLOG");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId());
        }
        return this.client;
    }
}
