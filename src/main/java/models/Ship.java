package models;

import java.util.List;

public class Ship {
   private List<Integer> x;
   private List<Integer> y;
   private String name;

   public List<Integer> getX() {
      return x;
   }

   public void setX(List<Integer> x) {
      this.x = x;
   }

   public List<Integer> getY() {
      return y;
   }

   public void setY(List<Integer> y) {
      this.y = y;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
