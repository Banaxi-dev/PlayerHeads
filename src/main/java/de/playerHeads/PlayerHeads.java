package de.playerHeads;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerHeads extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("PlayerHeadDrop aktiviert!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PlayerHeadDrop deaktiviert.");
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwningPlayer(event.getEntity());
        meta.setDisplayName(event.getEntity().getName() + "'s Kopf");
        head.setItemMeta(meta);

        event.getDrops().add(head);
    }
}