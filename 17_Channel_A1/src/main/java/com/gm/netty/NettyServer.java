package com.gm.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyServer {
    public void NettyServer() throws InterruptedException {
        //创建两个线程组bossGroup和workerGroup，含有的子线程NioEventLoop的个数默认为CPU的2倍
        //bossGroup只处理连接请求，workerGroup处理客户端业务
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup =new NioEventLoopGroup(8);

        try {
            //创建服务端启动对象
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            //链式编程配置参数
            serverBootstrap.group(bossGroup,workerGroup)//设置两个线程组
                    //使用NioServerSocketChannel作为服务器的通道实现
                    .channel(NioServerSocketChannel.class)
                    //初始化服务器连接队列大小，服务器处理客户端连接请求按顺序处理（同一时间只处理一个，同时多个请求时，将其他的放入队列里）
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("decoder",new StringDecoder());
                            pipeline.addLast("encoder",new StringEncoder());
                            //用NettyServerHandle来处理workerGroup的socketChannel
                            pipeline.addLast(new NettyServerHandle());
                        }
                    });
            System.out.println("netty 服务器开启");
            //监听9000端口-同步
            ChannelFuture channelFuture = serverBootstrap.bind(8081).sync();
            //关闭
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
