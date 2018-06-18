package com.github.JHXSMatthew.distributed_bungee;

import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Level;

/**
 * Created by JHXSMatthew on 17/6/18.
 */
public class DistributedBungee extends Plugin{

    @Override
    public void onEnable() {
        getLogger().info("Loading the distributed bungee..");
        //load configuration
        Config.getInstance();
        getLogger().info(" - config done.");

    }


}
