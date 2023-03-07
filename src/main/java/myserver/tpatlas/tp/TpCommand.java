package myserver.tpatlas.tp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TpCommand implements TabExecutor {
    public TpCommand(TpAtlas tpAtlas) {

    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;

            if(strings.length == 2){
                String playerName = commandSender.getName();
                String locationName = strings[1];
                Collection<? extends Player> onlinePlayers = Bukkit.getServer().getOnlinePlayers();
                ArrayList<String> playerNames = new ArrayList<>();
                for(Player playerOnline : onlinePlayers){
                    playerNames.add(playerOnline.getName());
                }

                if(playerNames.contains(locationName)){
                    player.teleport(Bukkit.getPlayer(locationName));
                } else {
                    for(Entry currentEntry : TpAtlas.listOfEntries){
                        if(currentEntry.getPlayerName() == playerName){
                            Location tpLocation;
                            tpLocation = new Location(Bukkit.getWorld("world"), currentEntry.getX(), currentEntry.getY(), currentEntry.getZ());
                            player.teleport(tpLocation);
                        }
                    }
                }


                player.sendMessage("Teleported to " + locationName);
                return true;
            }


        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        List<String> playersAndLocations = null;
        Collection<? extends Player> onlinePlayers = Bukkit.getServer().getOnlinePlayers();

        if(strings.length == 1){
            for(Player playerOnline : onlinePlayers){
                playersAndLocations.add(playerOnline.getName());
            }
            for(Entry currentEntry : TpAtlas.listOfEntries){
                if(currentEntry.getPlayerName() == commandSender.getName()){
                    playersAndLocations.add(currentEntry.getPlayerName());
                }
            }

        }

        return null;
    }
}
