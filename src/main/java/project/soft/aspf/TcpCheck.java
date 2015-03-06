package project.soft.aspf;

import project.protocol.header.Packet;
import project.soft.session.SessionItem;

/**
 * Created by ypbai on 2015/1/7.
 */
public abstract class TcpCheck {
   /**
    * Do tcp interactive check,
    * @return
    * @param sessionItem
    * @param packet
    */
   public static boolean doTcpCheck(SessionItem sessionItem, Packet packet) {
      //
      return true;
   }

   private static boolean handleIn(SessionItem si, Packet packet) {
      return true;
   }

   private static boolean handleOut(SessionItem si, Packet packet) {
      return true;
   }
}
