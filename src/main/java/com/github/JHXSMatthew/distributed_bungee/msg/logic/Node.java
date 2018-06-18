package com.github.JHXSMatthew.distributed_bungee.msg.logic;

import com.github.JHXSMatthew.distributed_bungee.msg.netty.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.Future;

/**
 * Created by JHXSMatthew on 18/6/18.
 */
public class Node {

    protected long id;
    protected String address;
    protected int port;

    public Node(long id, String address, int port){
        this.id = id;
        this.address = address;
        this.port = port;
    }



}
