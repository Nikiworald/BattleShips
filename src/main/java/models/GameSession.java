package models;

import java.util.Objects;

public class GameSession {
    private Player player1;
    private Player player2;
    private String status;
    private int id;
    private boolean player1Turn;
    //methods for attack


    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String makeHit(PlayerRequest playerRequest,int x,int y){
        if(Objects.equals(status, "fighting")) {
            if (playerRequest.getId() == player1.getId()) {
                if (player1Turn) {
                   int maxY= player2.getAttackBoard().getY();//todo fix player2 with player1
                   int maxX= player2.getAttackBoard().getX();
                   if(x>=0&&x<maxX){
                       if(y>=0&&y<maxY){
                           for (Hit h:
                                player2.getAttackBoard().getHitList()) {
                               if(h.getX()==x&&h.getY()==y){
                                   return "";
                               }

                           }
                           Hit hit = new Hit();
                           hit.setX(x);
                           hit.setY(y);
                           player2.getAttackBoard().getHitList().add(hit);//todo check if hits something on player 2 base board
                           return "";
                       }



                   }


                }


            }
        }




    }


}
