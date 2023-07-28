package de.mentania.chroniks.bowffa.listener;

import de.mentania.chroniks.bowffa.BowFFA;
import de.mentania.chroniks.bowffa.manager.StatsManager;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.SQLException;

public class JoinListener implements Listener {

    private final BowFFA plugin;

    private Inventory pinv;

    public JoinListener(BowFFA plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) throws SQLException {

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassmeta = compass.getItemMeta();
        compassmeta.setDisplayName("§aNavigator");
        compass.setItemMeta(compassmeta);

        Player p = event.getPlayer();

        pinv = p.getInventory();

        StatsManager manager = this.plugin.getSql().existsPlayeralready(p.getUniqueId().toString());
        if (manager == null){
            manager = new StatsManager(p.getUniqueId().toString(), p.getName(), 0, 0, 0, 0, 0);
            this.plugin.getSql().firstJoin(manager);
        }

        StatsManager name = this.plugin.getSql().changename(p.getUniqueId().toString());
        if (!name.equals(name)){
            name = new StatsManager(p.getUniqueId().toString(), p.getName());
            this.plugin.getSql().updatename(name);
        }

        pinv.setItem(3, compass);
        p.setGameMode(GameMode.ADVENTURE);
        p.setInvulnerable(true);


    }

    @EventHandler
    public void noHunger(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void noDrop(PlayerDropItemEvent event){

        if (event.getPlayer().getGameMode().equals(GameMode.ADVENTURE)){
            event.setCancelled(true);
        }else {
            event.setCancelled(false);
        }

    }

}
