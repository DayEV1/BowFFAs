package de.mentania.chroniks.bowffa.mysql;

import de.mentania.chroniks.bowffa.manager.StatsManager;

import java.sql.*;

public class MySQL {

    public Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        }


        String host = "jdbc:mysql://localhost/Mentania";
        String user = "Datenbank";
        String password = "1ADM8K3Nqc6aI3Q";

        this.connection = DriverManager.getConnection(host, user, password);
        System.out.println("Die Verbindung zur Datenbank wurde erfolgreich hergestellt!");

        return this.connection;
    }

    public void createplayerstats() throws SQLException{
        Statement statement = getConnection().createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS player_stats(uuid varchar(36) primary key, name text, wins int, loses int, kills int, death int, gamesinsgesamt int)";
        statement.execute(sql);
        statement.close();
    }

    public StatsManager existsPlayeralready(String uuid) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM player_stats WHERE uuid = ?");
        statement.setString(1, uuid);
        ResultSet result = statement.executeQuery();

        if (result.next()){
            String name = result.getString("name");
            int wins = result.getInt("wins");
            int loses = result.getInt("loses");
            int kills = result.getInt("kills");
            int deaths = result.getInt("deaths");
            int gamesinsgesamt = result.getInt("gamesinsgesamt");

            StatsManager manager = new StatsManager(uuid, name, wins, loses, kills, deaths, gamesinsgesamt);
            statement.close();
            return manager;

        }
        statement.close();
        return null;
    }

    public StatsManager changename(String uuid) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement("SELECT name FROM player_stats WHERE uuid = ?");
        statement.setString(1, uuid);
        ResultSet result = statement.executeQuery();

        if (result.next()){
            String name = result.getString("name");

            StatsManager manager = new StatsManager(uuid, name);
            statement.close();
            return manager;
        }
        statement.close();
        return null;
    }

    public void firstJoin(StatsManager manager) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement("INSERT INTO player_stats(uuid, name, wins, loses, kills, deaths, gamesinsgesamt) VALUES (?,?,?,?,?,?,?)");
        statement.setString(1, manager.getUuid());
        statement.setString(2, manager.getName());
        statement.setInt(3, manager.getWins());
        statement.setInt(4, manager.getLoses());
        statement.setInt(5, manager.getKills());
        statement.setInt(6, manager.getDeaths());
        statement.setInt(7, manager.getGamesinsgesamt());

        statement.executeUpdate();
        statement.close();
    }

    public void updatename(StatsManager manager) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement("UPDATE player_stats SET name = ? WHERE uuid = ?");
        statement.setString(1, manager.getUuid());
        statement.setString(2, manager.getName());
        statement.executeUpdate();
        statement.close();
    }

    public void updatewins(StatsManager manager) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement("UPDATE player_stats SET wins = ? WHERE uuid = ?");
        statement.setString(1, manager.getUuid());
        statement.setInt(2, manager.getWins());
        statement.executeUpdate();
        statement.close();
    }

    public void updateloses(StatsManager manager) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement("UPDATE player_stats SET loses = ? WHERE uuid = ?");
        statement.setString(1, manager.getUuid());
        statement.setInt(2, manager.getLoses());
        statement.executeUpdate();
        statement.close();
    }

    public void updatekills(StatsManager manager) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement("UPDATE player_stats SET kills = ? = WHERE uuid = ?");
        statement.setString(1, manager.getUuid());
        statement.setInt(2, manager.getKills());
        statement.executeUpdate();
        statement.close();
    }

    public void updatedeaths(StatsManager manager) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("UPDATE player_stats SET deaths = ? WHERE uuid = ?");
        statement.setString(1, manager.getUuid());
        statement.setInt(2, manager.getDeaths());
        statement.executeUpdate();
        statement.close();
    }

    public void updateallmatches(StatsManager manager) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement("UPDATE player_stas SET deaths = ? WHERE uuid = ?");
        statement.setString(1, manager.getUuid());
        statement.setInt(2, manager.getGamesinsgesamt());
        statement.executeUpdate();
        statement.close();
    }

}
