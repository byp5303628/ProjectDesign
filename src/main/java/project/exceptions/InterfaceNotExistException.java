package project.exceptions;

public class InterfaceNotExistException extends Exception {

   /**
    * 
    */
   private static final long serialVersionUID = 572080684822280534L;

   public InterfaceNotExistException(int index) {
      System.out.println("Interface : \"" + index + "\" does not exist!");
   }

}
