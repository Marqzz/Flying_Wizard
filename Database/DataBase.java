package MyGame.Database;


import MyGame.Entities.Player;

import java.sql.*;
import java.time.Instant;

public class DataBase {
    //method to insert timestamp into DB
    public static void insertTimestamp(){
        Instant timestamp = Instant.now();
        Connection c = null;
        Statement statement = null;

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MyDataBase.db");
            statement = c.createStatement();
            c.setAutoCommit(false);

            System.out.println("timestamp.DataBase.java:"+timestamp);
            int rez = timestamp.getNano();

            String sql = "INSERT INTO played (timestamp,points) "+
                    "VALUES ("+rez+","+ Player.counter+")";

            statement.executeUpdate(sql);
            c.commit();
            statement.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
