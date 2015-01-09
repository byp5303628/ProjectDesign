package project.soft.aspf;

import project.protocol.header.Packet;
import project.protocol.header.layer4.LAYER_4_PROTOCOL;
import project.soft.session.SessionItem;

/**
 * Created by ypbai on 2015/1/7.
 */
public class Aspf {
   boolean tcpEnable;
   boolean udpEnable;
   boolean rawIpEnable;

   public Aspf() {
      tcpEnable = false;
      udpEnable = false;
      rawIpEnable = false;
   }

   /**
    * Check through all modules in Aspf, if it allows, return true, else return
    * false.
    * 
    * @param sessionItem
    *           , which is the sessionItem matched from session table.
    * @param packet
    *           , which is the packet want to check
    * @return if the packet can pass, return true and update session item's time
    *         and session status, else return false.
    */
   public boolean isPacketAllowed(SessionItem sessionItem, Packet packet) {
      LAYER_4_PROTOCOL protocol = packet.getLayer4Protocol();
      switch (protocol) {
      case TCP:
         if (tcpEnable)
            return TcpCheck.doTcpCheck(sessionItem, packet);
         return true;
      case UDP:
         if (udpEnable)
            return UdpCheck.doUdpCheck(sessionItem, packet);
         return true;
      case RAW_IP:
         if (rawIpEnable)
            return RawIpCheck.doRawIpCheck(sessionItem, packet);
         return true;
      default:
         return true;
      }
   }

   public void setTcpEnable(boolean tcpEnable) {
      this.tcpEnable = tcpEnable;
   }

   public void setUdpEnable(boolean udpEnable) {
      this.udpEnable = udpEnable;
   }

   public void setRawIpEnable(boolean rawIpEnable) {
      this.rawIpEnable = rawIpEnable;
   }
}
