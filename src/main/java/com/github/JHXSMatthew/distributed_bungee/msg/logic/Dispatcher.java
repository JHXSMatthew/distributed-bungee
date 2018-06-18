package com.github.JHXSMatthew.distributed_bungee.msg.logic;

import com.github.JHXSMatthew.distributed_bungee.event.EventDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JHXSMatthew on 18/6/18.
 */
public class Dispatcher {

    private long self;
    private List<Long> knowledge;


    private EventDriver driver;

    public Dispatcher(EventDriver driver){
        knowledge = new ArrayList<>();
        this.driver = driver;

        initNetty();
    }

    private void initNetty(){

    }




}
