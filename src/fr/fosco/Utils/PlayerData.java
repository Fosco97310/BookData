package fr.fosco.Utils;

public class PlayerData {

    private int coins;
    private int page;
    public PlayerData(int page, int coins){
        this.page = page;
        this.coins = coins;
    }

    public int getPage() { return page; }

    public void setPage(int page) { this.page = page; }

    public int getCoins() { return coins; }

    public void setCoins(int coins) { this.coins = coins; }
}
