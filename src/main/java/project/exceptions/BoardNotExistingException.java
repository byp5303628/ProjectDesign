package project.exceptions;

public class BoardNotExistingException extends Exception {
   private static final long serialVersionUID = 1L;

   public BoardNotExistingException(int slotNum) {
      System.out.println("Board in Machine Frame slot " + slotNum
            + " does not exist");
   }
}
