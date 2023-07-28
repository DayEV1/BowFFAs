package de.mentania.chroniks.bowffa.commands;

import de.mentania.chroniks.bowffa.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class VanishCommand implements CommandExecutor {

    private ArrayList<Player> vanish = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;



                if (p.hasPermission("Mentania.BowFFA.vanish")) {

                    if (!vanish.contains(p)) {

                    vanish.add(p);

                    p.sendMessage(Utils.getPrefix() + " Vanish §aaktiviert!");

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.hidePlayer(p);
                    }

                } else {

                    vanish.remove(p);
                    p.sendMessage(Utils.getPrefix() + " Vanish §cdeaktivert!");

                    for (Player all : Bukkit.getOnlinePlayers()){
                        all.showPlayer(p);
                    }

                }

            } else {
                    p.sendMessage(Utils.keineRechte());
                }


        }
        return false;
    }

}
