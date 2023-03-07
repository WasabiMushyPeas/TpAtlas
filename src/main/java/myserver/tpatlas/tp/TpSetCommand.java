package myserver.tpatlas.tp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.bukkit.entity.Player;

import java.util.List;

public class TpSetCommand implements TabExecutor {
    public TpSetCommand(TpAtlas tpAtlas) {

    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;

            if(strings.length == 2){
                String playerName = commandSender.getName();
                String locationName = strings[1];
                int x = player.getLocation().getBlockX();
                int y = player.getLocation().getBlockY();
                int z = player.getLocation().getBlockZ();

                Entry entry = new Entry(x, y, z, playerName, locationName);
                entry.setPlayerName(playerName);
                entry.setLocationName(locationName);
                entry.setX(x);
                entry.setY(y);
                entry.setZ(z);

                TpAtlas.listOfEntries.add(entry);

                player.sendMessage("Location " + locationName + " has been set to " + x + ", " + y + ", " + z);
                return true;
            }


        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return null;
    }
}
