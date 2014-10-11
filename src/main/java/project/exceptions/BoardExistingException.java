package project.exceptions;

public class BoardExistingException extends Exception {
   private static final long serialVersionUID = 1L;

   public BoardExistingException(int slotNum) {
      System.out
            .println("Board in Machine Frame slot " + slotNum + " existing");
   }
}
