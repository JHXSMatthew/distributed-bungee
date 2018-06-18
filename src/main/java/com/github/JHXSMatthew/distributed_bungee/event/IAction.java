package com.github.JHXSMatthew.distributed_bungee.event;

/**
 * Created by JHXSMatthew on 18/6/18.
 */
public interface IAction {

    ActionType getActionTyoe();
    KeyValue[] getKeyValue();

}
