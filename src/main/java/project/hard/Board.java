package project.hard;

public class Board {
   /*
    * A base class for several kinds of boards.
    */
   private String type;
   private int slot;

   public void displaySession() {
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public int getSlot() {
      return slot;
   }

   public void setSlot(int slot) {
      this.slot = slot;
   }

}
