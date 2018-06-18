package com.github.JHXSMatthew.distributed_bungee.msg.logic;

import com.github.JHXSMatthew.distributed_bungee.msg.netty.Message;

/**
 * Created by JHXSMatthew on 18/6/18.
 */
public abstract class OperationWrapper {




    public abstract boolean isFinished();

    public abstract Message ask(Message msg);
    public abstract Message ask();


    protected void onSend(byte[] b){

    }

}
