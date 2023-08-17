package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int x;
    private int y;
    private List<Hit> hitList = new ArrayList<Hit>();
    private List<Ship> shipList = new ArrayList<Ship>();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Hit> getHitList() {
        return hitList;
    }

    public void setHitList(List<Hit> hitList) {
        this.hitList = hitList;
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(List<Ship> shipList) {
        this.shipList = shipList;
    }
}
