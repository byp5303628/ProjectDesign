package project.exceptions;

public class DestinationNotReachableException extends Exception {
   /**
    * 
    */
   private static final long serialVersionUID = 6083471300473288565L;

   public DestinationNotReachableException() {
      System.out.println("Destination is not reachable!");
   }
}
