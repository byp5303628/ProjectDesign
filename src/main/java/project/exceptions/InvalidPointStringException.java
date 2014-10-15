package project.exceptions;

public class InvalidPointStringException extends Exception {

   /**
    * 
    */
   private static final long serialVersionUID = 5174826630924269670L;

   public InvalidPointStringException(String input) {
      System.out.println("Point String Ip Address :\"" + input
            + "\" is not valid!");
   }

}
