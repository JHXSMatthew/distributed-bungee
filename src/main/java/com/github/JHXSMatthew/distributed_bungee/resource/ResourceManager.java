package com.github.JHXSMatthew.distributed_bungee.resource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by JHXSMatthew on 18/6/18.
 */
public class ResourceManager {


    private static ResourceManager instance;

    public static ResourceManager getInstance(){
        if(instance == null){
            instance = new ResourceManager();
        }

        return instance;
    }


    private ExecutorService threadPool;

    private ResourceManager(){
        this.threadPool = Executors.newCachedThreadPool();
    }


    public Future submit(Runnable runnable){
        return threadPool.submit(runnable);
    }

    public void execute(Runnable runnable){
        threadPool.execute(runnable);
    }

}
