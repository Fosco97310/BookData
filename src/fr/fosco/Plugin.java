package fr.fosco;


import fr.fosco.Events.JoinLeaveEvents;
import fr.fosco.Utils.BookData;
import fr.fosco.Utils.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;


public class Plugin extends JavaPlugin{

    public ItemStack book;
    public HashMap<UUID, PlayerData> players = new HashMap<>();

    @Override
    public void onEnable() {
        Location loc = new Location(Bukkit.getWorld("world"), 202, 72, 8);
        Chest chest = (Chest) loc.getBlock().getState();
        book = chest.getInventory().getItem(0);
        getServer().getPluginManager().registerEvents(new JoinLeaveEvents(this), this);

        for(Player player : Bukkit.getOnlinePlayers()){
            new BookData(this).loadData(player);
        }
    }

    @Override
    public void onDisable() {
        for(Player player : Bukkit.getOnlinePlayers()){
            new BookData(this).saveData(player);
        }
    }
}
