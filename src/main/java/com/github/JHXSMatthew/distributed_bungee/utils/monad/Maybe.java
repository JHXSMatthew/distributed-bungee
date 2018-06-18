package com.github.JHXSMatthew.distributed_bungee.utils.monad;

/**
 * Created by JHXSMatthew on 17/6/18.
 */
public abstract class Maybe <T>{

    public abstract boolean isJust();
    public abstract boolean isNothing();

    public T val() {
        //should never call this line
        return null;
    }
}
