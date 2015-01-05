package project.exceptions;

/**
 * Created by ypbai on 2015/1/5.
 */
public class InvalidUdpPacketException extends Exception {
   private static final long serialVersionUID = 1L;

   public InvalidUdpPacketException(int len) {
      System.out.println("UDP packet length " + len + " is not correct");
   }
}
