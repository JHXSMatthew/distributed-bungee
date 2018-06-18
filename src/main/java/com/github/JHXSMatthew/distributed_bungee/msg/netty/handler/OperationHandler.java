package com.github.JHXSMatthew.distributed_bungee.msg.netty.handler;

import com.github.JHXSMatthew.distributed_bungee.msg.logic.OperationWrapper;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Semaphore;

/**
 * Created by JHXSMatthew on 18/6/18.
 */
public class OperationHandler extends ChannelInboundHandlerAdapter {

    private ChannelHandlerContext ctx;
    private Semaphore semaphore ;
    protected OperationWrapper wrapper;

    public OperationHandler(){
        this.semaphore = new Semaphore(0);
    }

    public boolean startOperation(OperationWrapper wrapper) {
        if (ctx == null) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                return false;
            }
        }

        ChannelFuture cf = ctx.write(wrapper.ask());
        ctx.flush();
        if (!cf.isSuccess()) {
            System.err.println("Send failed: " + cf.cause());
            return false;
        }
        return true;
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
        semaphore.release();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg; // (1)
        try {

        } finally {
            m.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
