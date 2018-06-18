package com.github.JHXSMatthew.distributed_bungee.event;

import com.github.JHXSMatthew.distributed_bungee.resource.ResourceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JHXSMatthew on 18/6/18.
 */
public class EventDriver {

    private List<IListener> listeners;

    public EventDriver(){
        listeners = new ArrayList<>();
    }

    public void publish(final IAction action){
        synchronized (listeners){
            final IListener[] copy = listeners.toArray(new IListener[listeners.size()]);
            ResourceManager.getInstance().submit(new Runnable() {
                @Override
                public void run() {
                    Arrays.stream(copy).forEach(i -> {
                      i.onCall(action);
                    });
                }
            });
        }
    }

    public Runnable subscribe(IListener listener){
        int index = -1;
        synchronized (listeners){
            listeners.add(listener);
            index = listeners.size() - 1;
        }

        int finalIndex = index;
        return () -> {
            synchronized (listeners){
                listeners.remove(finalIndex);
            }
        };
    }

}
