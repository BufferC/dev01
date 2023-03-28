package com.gm.server;

import com.gm.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Send_01 {
    private final static String QUEUE_NAME = "task_queue";
    //（一）
    /*public static void main(String[] args){
        ConnectionUtil connectionUtil = new ConnectionUtil();
        ConnectionFactory connectionFactory = connectionUtil.getConnection();
        *//*
        try(){}catch(){}结构中，写在try后面的括号中的对象会在try执行完毕后自动调用close()方法闭流。
        注意事项自己百度
         *//*
        try(
                //创建连接
                Connection connection =connectionFactory.newConnection();
                //创建通道
                Channel channel = connection.createChannel();
            ) {
            //队列声明
            *//*
            channel.queueDeclare参数说明
            1->队列名
            2->是否持久化
            3->是否排外
            4->是否自动删除
            5->设置队列的其他一些参数
             *//*
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            //发送信息内容
            String message = "Hello World!";
            *//*
            exchange：交换机，如果为空的，routingKey的规则就是routingKey需要和消息队列的名称一样，不然就发送失败
            routingKey：路由键，#匹配0个或多个单词，*匹配一个单词，在topic exchange做消息转发用
            props：需要注意的是BasicProperties.deliveryMode，1:不持久化 2：持久化 这里指的是消息的持久化，配合channel(durable=true),queue(durable)可以实现，即使服务器宕机，消息仍然保留
            body：要发送的信息
             *//*
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }*/

    //（二）
    /*public static void main(String[] args) {
        ConnectionUtil connectionUtil = new ConnectionUtil();
        ConnectionFactory connectionFactory = connectionUtil.getConnection();
        try(
            Connection connection =connectionFactory.newConnection();
            Channel channel = connection.createChannel();
        ) {
            //*change* :参数2 改为true
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            for (int i = 0; i < 10; i++){
                String message = ""+i;
                //*change* :参数3 改为MessageProperties.PERSISTENT_TEXT_PLAIN
                channel.basicPublish("", QUEUE_NAME,  MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
                System.out.println(" [x] Sent '" + message + "'");
                Thread.sleep(1000);
            }

        } catch (IOException | TimeoutException | InterruptedException e) {
            e.printStackTrace();
        }
    }*/
    //（三）https://www.rabbitmq.com/tutorials/tutorial-three-java.html
    public static void main(String[] args) {
        ConnectionUtil connectionUtil = new ConnectionUtil();
        ConnectionFactory connectionFactory = connectionUtil.getConnection();
        try(
                Connection connection =connectionFactory.newConnection();
                Channel channel = connection.createChannel();
        ) {
            //创建交换机
            channel.exchangeDeclare("exchangeName","fanout");
            String message = "info: Hello World!";
            //向交换机发消息
            channel.basicPublish("exchangeName", "",  null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");


        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
    //（四）https://www.rabbitmq.com/tutorials/tutorial-four-java.html -----与三只有小改动，不在写了，自己看
    //（五）https://www.bilibili.com/video/BV1TE411g74u?p=13&spm_id_from=pageDriver&vd_source=e60b709cc3d4aa69e53c8a8b874dfe6b
    //与四只是规则不同，不在写了，哔哩哔哩看
    //（六）https://www.rabbitmq.com/tutorials/tutorial-six-java.html -----不想写了

}
