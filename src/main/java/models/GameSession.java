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

    public String makeHit(PlayerRequest playerRequest, int x, int y) {
        if (Objects.equals(status, "fighting")) {
            if (playerRequest.getId() == player1.getId()) {//todo add player2 check
                if (player1Turn) {
                    int maxY = player2.getAttackBoard().getY();
                    int maxX = player2.getAttackBoard().getX();
                    if (x >= 0 && x < maxX) {
                        if (y >= 0 && y < maxY) {
                            for (Hit h : player1.getAttackBoard().getHitList()) {
                                if (h.getX() == x && h.getY() == y) {
                                    return "already attacked this spot";
                                }
                            }
                            Hit hit = new Hit();
                            hit.setX(x);
                            hit.setY(y);
                            hit.setStatus("miss");
                            for (Ship ship : player2.getBasesBoard().getShipList()) {
                                if (ship.getX().contains(x) && ship.getY().contains(y)) {
                                    hit.setStatus("hit");
                                    break;
                                }
                            }
                            player1.getAttackBoard().getHitList().add(hit);
                            return "successful attack";
                        } else {
                            return "hit out of bounds";
                        }


                    } else {
                        return "hit out of bounds";
                    }


                } else {
                    return "not your turn";
                }


            } else {
                return "player id not matching ";
            }
        } else {
            return "cannot attack in this game stage";
        }
    }

    public String makeShip(PlayerRequest playerRequest, int x, int y, int shipType, byte state) {
        if (Objects.equals(status, "setup")) {
            int
            if (playerRequest.getId() == player1.getId()) {
                if (player1Turn) {
                    int maxY = player1.getBasesBoard().getY();
                    int maxX = player1.getBasesBoard().getX();
                    if (x >= 0 && x < maxX) {//todo multiple cord and rotations
                        if (y >= 0 && y < maxY) {
//                            for (Hit h : player1.getAttackBoard().getHitList()) {
//                                if (h.getX() == x && h.getY() == y) {
//                                    return "already attacked this spot";
//                                }
//                            }
                            for (Ship ship : player1.getBasesBoard().getShipList()) {
                                if (ship.getY().contains(y) && ship.getX().contains(x)) {
                                    return "another ship in the way";
                                }
                            }
                            Ship ship = new Ship();
                            //todo find the cord where to place
//                            Hit hit = new Hit();
//                            hit.setX(x);
//                            hit.setY(y);
//                            hit.setStatus("miss");
//                            for (Ship ship : player2.getBasesBoard().getShipList()) {
//                                if (ship.getX().contains(x) && ship.getY().contains(y)) {
//                                    hit.setStatus("hit");
//                                    break;
//                                }
//                            }
//                            player1.getAttackBoard().getHitList().add(hit);
//
                            player1.getBasesBoard().getShipList().add(ship);
                            return "successful ship placement";
                        } else {
                            return "ship out of bounds";
                        }


                    } else {
                        return "ship out of bounds";
                    }


                } else {
                    return "not your turn";
                }


            } else {
                return "player id not matching ";
            }
        } else {
            return "cannot attack in this game stage";
        }


    }


}
