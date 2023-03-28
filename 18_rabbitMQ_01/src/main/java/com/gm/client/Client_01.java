package com.gm.client;

import com.gm.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Client_01 {
    private final static String QUEUE_NAME = "task_queue";
//(一）
    /*public static void main(String[] argv) throws Exception {
        ConnectionUtil connectionUtil = new ConnectionUtil();
        ConnectionFactory connectionFactory = connectionUtil.getConnection();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
        };
        *//*
        channel.basicConsume参数
        1-> 创建消费者（监听器）
        2-> 是否自动确认接收消息，TRUE是，false不（手动确认）
        2->
         *//*
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });

    }*/
//（二）
    /*public static void main(String[] argv) {
        Thread thread1 = new Thread(()->{
            try {
                new Client_01().client(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(()->{
            try {
                new Client_01().client(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //模拟多个客户端
        thread1.start();
        thread2.start();

    }

    public void client(int num) throws Exception{
        ConnectionUtil connectionUtil = new ConnectionUtil();
        ConnectionFactory connectionFactory = connectionUtil.getConnection();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        //+code+ :表示一次只处理一个
        channel.basicQos(1);

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" num"+num+"-----------------------");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(num+" '" + message + "'");

            //+code+ :模拟延迟
            try {
                Thread.sleep(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //+code+ : 消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息（成功消费，消息从队列中删除 ）
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

        };
        //*change* :参数改为false，表示手动确认
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> { });
    }*/

    //（三）--这里不在尝试多个客户端
    public static void main(String[] args) throws Exception {
        ConnectionUtil connectionUtil = new ConnectionUtil();
        ConnectionFactory connectionFactory = connectionUtil.getConnection();

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare("exchangeName","fanout");
        //获得当前队列名
        String queueName = channel.queueDeclare().getQueue();
        //绑定交换机和队列
        channel.queueBind(queueName, "exchangeName", "");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }
    //（四）https://www.rabbitmq.com/tutorials/tutorial-four-java.html
}
