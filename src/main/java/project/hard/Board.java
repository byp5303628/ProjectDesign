package project.hard;

public class Board {
   /*
    * A base class for several kinds of boards.
    */
   private String type;

   public Board() {
      this.setType(null);
   }

   public void displaySession() {
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

}
