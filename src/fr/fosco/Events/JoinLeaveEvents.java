package fr.fosco.Events;

import fr.fosco.Plugin;
import fr.fosco.Utils.BookData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveEvents implements Listener {


    private Plugin main;
    public JoinLeaveEvents(Plugin main){
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        new BookData(main).loadData(player);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        new BookData(main).saveData(player);
    }

}
