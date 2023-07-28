package de.mentania.chroniks.bowffa.manager;

public class StatsManager {

    private String uuid;
    private String name;
    private int wins;
    private int loses;
    private int kills;
    private int deaths;
    private int gamesinsgesamt;

    public StatsManager(String uuid, String name, int wins, int loses, int kills, int deaths, int gamesinsgesamt){
        this.uuid = uuid;
        this.name = name;
        this.wins = wins;
        this.loses = loses;
        this.kills = kills;
        this.deaths = deaths;
        this.gamesinsgesamt = gamesinsgesamt;
    }

    public StatsManager(String uuid, String name){
        this.uuid = uuid;
        this.name = name;
    }

    public StatsManager(String uuid, int wins){
        this.uuid = uuid;
        this.wins = wins;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getGamesinsgesamt() {
        return gamesinsgesamt;
    }

    public void setGamesinsgesamt(int gamesinsgesamt) {
        this.gamesinsgesamt = gamesinsgesamt;
    }
}
