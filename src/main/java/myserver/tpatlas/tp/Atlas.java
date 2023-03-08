package myserver.tpatlas.tp;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.ArrayList;

public class Atlas {
    private static ArrayList<Entry> listOfLocations;
    private Player player;

    // Constructor
    public ArrayList<Atlas> atlasArrayList;

    public Atlas(Player player) {
        this.player = player;
        //probably need to write it to a file so people don't lose their stuff.

        //Create a data structure to store the items for sale.  This structure should store the following:
        //  1. The seller
        //  2. The item stack for sale
        //  3. The item they want in return
        //  4. The quantity they want
        //Method to
        boolean tryToOpenFile = true;

        atlasArrayList = new ArrayList<Atlas>();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("atlas.file");
        } catch (FileNotFoundException e) {
            System.out.println("Valid atlas.file not found.");
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
                atlasArrayList = (ArrayList) ois.readObject();
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

        if(!atlasArrayList.isEmpty()){
            System.out.println(ChatColor.BLUE + "Printing the list.");
        }
    }


    // Getters and Setters
    public ArrayList<Entry> getListOfLocations() {
        return listOfLocations;
    }

    public static void addLocation(Entry entry) {
        listOfLocations.add(entry);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void saveAtlas(){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("atlas.file");
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
            oos.writeObject(atlasArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}