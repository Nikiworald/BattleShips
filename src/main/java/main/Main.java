package main;

import db.DbConnection;
import models.GameSession;
import models.Player;

public class Main {

    public static void main(String[] args) {
        GameSession gameSesion = new GameSession();
        Player player1 = new Player();
        Player player2 = new Player();
        DbConnection.getConnection();




    }

}
