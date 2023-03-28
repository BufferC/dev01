package com.gm.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NettyServerHandle extends SimpleChannelInboundHandler<String> {
    //GlobalEventExecutor.INSTANCE 全局事件处理器--单例
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    /**
     * 客户端连接服务器后触发方法
     * @param ctx 上下文对象，含有通道channel，普通pipeline
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        Date date = new Date();
        String dt = simpleDateFormat.format(date);
        channelGroup.writeAndFlush("【客户端】"+channel.remoteAddress()+"连接上线: " + dt + "\n");
        channelGroup.add(channel);
        System.out.println("客户端"+channel.remoteAddress()+"连接上线\n");
    }

    /**
     * 当channel处于不活跃状态，提示下线
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("-----> 客户端" + channel.remoteAddress() + "已下线\n");
        System.out.println("-----> 客户端" + channel.remoteAddress() + "已下线\n" +
                "当前在线人数为："+ channelGroup.size()+"\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭通道
        ctx.close();
    }

    /**
     * 读取客户端发送的数据
     * @param channelHandlerContext 上下文对象，含有通道channel，普通pipeline
     * @param msg 客户端发送的数据
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {

        Channel channel = channelHandlerContext.channel();
        channelGroup.forEach(ch -> {
            System.out.println(ch+"----"+channel);
            if (ch != channel){
                ch.writeAndFlush("【客户端】"+channel.remoteAddress()+"发出的消息："+msg+"\n");
            }else {
                ch.writeAndFlush("【我】发出的消息"+msg+"\n");
            }
        });
    }
}
