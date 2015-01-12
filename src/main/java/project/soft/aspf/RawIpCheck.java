package project.soft.aspf;

import project.protocol.header.Packet;
import project.soft.session.SessionItem;

/**
 * Created by ypbai on 2015/1/7.
 */
public abstract class RawIpCheck {
   public static boolean doRawIpCheck(SessionItem sessionItem, Packet packet) {
      return true;
   }
}
