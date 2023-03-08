package myserver.tpatlas.tp;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class TpAtlas extends JavaPlugin {
    private ArrayList<Entry> listOfPostings;

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
