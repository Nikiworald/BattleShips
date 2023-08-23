package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private int id;

    private Board attackBoard;
    private Board basesBoard;

    public Board getAttackBoard() {
        return attackBoard;
    }

    public void setAttackBoard(Board attackBoard) {
        this.attackBoard = attackBoard;
    }

    public Board getBasesBoard() {
        return basesBoard;
    }

    public void setBasesBoard(Board basesBoard) {
        this.basesBoard = basesBoard;
    }

    public String getCokie() {
        return cokie;
    }

    public void setCokie(String cokie) {
        this.cokie = cokie;
    }

    private String cokie;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}
