package project.exceptions;

public class InvalidMacAddressException extends Exception {
   /**
    * 
    */
   private static final long serialVersionUID = 8353513632471445524L;

   public InvalidMacAddressException(String addr) {
      System.out.println("Mac Address: \"" + addr +"\" is not valid!");
   }
}
