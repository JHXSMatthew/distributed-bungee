package com.github.JHXSMatthew.distributed_bungee.utils.monad;

/**
 * Created by JHXSMatthew on 17/6/18.
 */
public class Nothing extends Maybe {

    public static Nothing instance = new Nothing();

    @Override
    public boolean isJust() {
        return false;
    }

    @Override
    public boolean isNothing() {
        return true;
    }

}
