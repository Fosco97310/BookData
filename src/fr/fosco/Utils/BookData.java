package fr.fosco.Utils;

import fr.fosco.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BookMeta;


public class BookData {


    private BookMeta bookMeta;
    private Plugin main;
    public BookData(Plugin main){
        this.main = main;
        bookMeta = (BookMeta) main.book.getItemMeta();
    }

    private void createData(Player player){
        if(!hasAccout(player)){
            int pages = bookMeta.getPageCount();
            String data = "";
            data += player.getUniqueId();
            data += ":";
            data += 0;
            data += ":";
            data += pages;

            if(pages == 1) {
                bookMeta.setPage(pages, data);
            } else {
                pages = pages+1;
                bookMeta.setPage(pages, data);
            }

            main.book.setItemMeta(bookMeta);
            main.players.put(player.getUniqueId(), new PlayerData(pages, 0));
        }
    }

    public void loadData(Player player){
        createData(player);
        for(String str : bookMeta.getPages()){
            if(str.contains(String.valueOf(player.getUniqueId()))){
                String[] newStr = str.split(":");
                int coins = Integer.valueOf(newStr[1]);
                int page = Integer.valueOf(newStr[2]);
                main.players.put(player.getUniqueId(), new PlayerData(page, coins));
            }
        }
    }

    public void saveData(Player player){
        PlayerData playerData = main.players.get(player.getUniqueId());
        String data = "";
        data += player.getUniqueId();
        data += ":";
        data += playerData.getCoins();
        data += ":";
        data += playerData.getPage();
        bookMeta.setPage(playerData.getPage(), data);
        main.book.setItemMeta(bookMeta);
        main.players.remove(player.getUniqueId());
    }

    private boolean hasAccout(Player player){
        for(String str : bookMeta.getPages()){
            if(str.contains(String.valueOf(player.getUniqueId()))){
                return true;
            }
        }
        return false;
    }

}
