package com.github.JHXSMatthew.distributed_bungee;

import java.util.Random;

/**
 * Created by JHXSMatthew on 17/6/18.
 */
public class Config {

    private static Config instance;

    public static Config getInstance(){
        if(instance == null){
            instance = new Config();
            if(!instance.load()){
                instance = null;
            }
        }

        return instance;
    }

    private int id = new Random().nextInt(10);
    private String name = "test" + id;
    private String knownAddress = "127.0.0.1:20000";

    public String getName(){
        return name;
    }

    public String getKnownAddr(){
        return knownAddress;
    }

    public int getId(){
        return id;
    }




    public boolean load(){
        //TODO implement this
        return true;

    }

    public boolean save(){
        //TODO implement this
        return true;
    }
}
