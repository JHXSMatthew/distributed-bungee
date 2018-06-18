package com.github.JHXSMatthew.distributed_bungee.event;

import com.github.JHXSMatthew.distributed_bungee.event.IAction;

/**
 * Created by JHXSMatthew on 18/6/18.
 */
public interface IListener {

    void onCall(IAction action);
}
