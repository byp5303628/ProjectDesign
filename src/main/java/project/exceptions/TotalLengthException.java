package project.exceptions;

public class TotalLengthException extends Exception {

   /**
    * 
    */
   private static final long serialVersionUID = 3580932592567520345L;

   public TotalLengthException(int num) {
      System.out.println("Total Length should be from 20 to 65535, not \""
            + num + "\"");
   }
}
