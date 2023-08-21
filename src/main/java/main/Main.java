package main;

import db.DbConnection;
import map.GameSessionMap;
import models.GameSession;
import models.Player;
import models.PlayerRequest;

public class Main {

    public static void main(String[] args) {
        DbConnection.getConnection();
        PlayerRequest plr1req= new PlayerRequest();
        plr1req.setId(1);
        plr1req.setName("test1");
        PlayerRequest plr2req= new PlayerRequest();
        plr2req.setId(2);
        plr2req.setName("test2");
        System.out.println( GameSessionMap.createGame(plr1req));//todo no output if successful
        System.out.println( GameSessionMap.joinGame(25,plr2req));
        System.out.println(GameSessionMap.deleteGame(25));




    }

}
