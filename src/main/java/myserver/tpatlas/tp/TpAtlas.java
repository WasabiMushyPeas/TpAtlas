package myserver.tpatlas.tp;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public final class TpAtlas extends JavaPlugin {
    private ArrayList<Atlas> listOfPostings;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new TpAtlasEvent(this), this);
        System.out.println("TpAtlas is enabled!");

        getCommand("tpa").setExecutor(new TpCommand(this));
        getCommand("tpaSet").setExecutor(new TpSetCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("TpAtlas is disabled!");
    }



}
