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

            if(strings.length == 4){
                String playerName = commandSender.getName();
                String locationName = strings[1];
                int x = Integer.parseInt(strings[2]);
                int y = Integer.parseInt(strings[3]);
                int z = Integer.parseInt(strings[4]);

                Atlas atlas = new Atlas(x, y, z, playerName, locationName);
                atlas.setPlayerName(playerName);
                atlas.setLocationName(locationName);
                atlas.setX(x);
                atlas.setY(y);
                atlas.setZ(z);

                TpAtlas.atlasList.add(atlas);

                player.sendMessage("Atlas set!");
            }


        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return null;
    }
}
