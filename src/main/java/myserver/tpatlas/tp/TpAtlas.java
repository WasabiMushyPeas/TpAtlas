package myserver.tpatlas.tp;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public final class TpAtlas extends JavaPlugin {
    public static ArrayList<Entry> listOfEntries = new ArrayList<>();

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
        System.out.println("Starting Backup");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("market.file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            oos.writeObject(listOfEntries);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("TpAtlas is disabled!");
    }


    public void readEntries(){

        boolean tryToOpenFile = true;

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("market.file");
        } catch (FileNotFoundException e) {
            System.out.println("Valid market.file not found.");
            tryToOpenFile = false;
        }if (tryToOpenFile) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(ChatColor.BLUE + "Reading in the list.");
                listOfEntries = (ArrayList<Entry>) ois.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!listOfEntries.isEmpty()){

        }
    }



}
