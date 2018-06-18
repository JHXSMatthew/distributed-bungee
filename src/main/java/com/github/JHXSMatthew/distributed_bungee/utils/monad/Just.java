package com.github.JHXSMatthew.distributed_bungee.utils.monad;

/**
 * Created by JHXSMatthew on 17/6/18.
 */
public class Just<T> extends Maybe<T> {

    private T value;

    public Just(T value){
        this.value = value;
    }

    @Override
    public T val(){
        return value;
    }

    @Override
    public boolean isJust() {
        return value != null;
    }

    @Override
    public boolean isNothing() {
        return value == null;
    }
}
