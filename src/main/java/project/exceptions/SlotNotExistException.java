package project.exceptions;

public class SlotNotExistException extends Exception {

   /**
    * 
    */
   private static final long serialVersionUID = 4945004647761901316L;

   public SlotNotExistException(int slotNum) {
      System.out.println("Slot number: \"" + slotNum + "\" is not exist!");
   }

}
