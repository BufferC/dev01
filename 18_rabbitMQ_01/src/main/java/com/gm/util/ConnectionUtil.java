package com.gm.util;

import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {
    /**
     * 获得rabbitmq连接工厂
     * @return rabbitmq连接工厂
     */
    public ConnectionFactory getConnection(){
        //创建rabbitmq连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置rabbitmq主机
        connectionFactory.setHost("192.168.254.128");
        connectionFactory.setPassword("admin");
        connectionFactory.setUsername("admin");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPort(5672);
        return connectionFactory;
    }
}
