package project.soft.session;

import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.datagram.layer4.Port;
import project.protocol.header.Packet;
import project.protocol.header.layer4.APPLICATION;
import project.protocol.header.layer4.LAYER_4_PROTOCOL;

/**
 * Created by ypbai on 2014/12/25.
 */
public class SessionItem {
   private final Ipv4Address inSrcIpv4Address;
   private final Port inSrcPort;
   private final Ipv4Address inDestIpv4Address;
   private final Port inDestPort;
   private final LAYER_4_PROTOCOL inProtocol;

   private final Ipv4Address outSrcIpv4Address;
   private final Port outSrcPort;
   private final Ipv4Address outDestIpv4Address;
   private final Port outDestPort;
   private final LAYER_4_PROTOCOL outProtocol;

   private final APPLICATION application;
   private final SessionStatus sessionStatus;

   private SessionItem(Packet packet) {
      this.inSrcIpv4Address = packet.getSrcIp();
      this.inDestIpv4Address = packet.getDestIp();
      this.inSrcPort = packet.getSrcPort();
      this.inDestPort = packet.getDestPort();
      this.inProtocol = packet.getLayer4Protocol();

      this.outSrcIpv4Address = packet.getDestIp();
      this.outDestIpv4Address = packet.getSrcIp();
      this.outSrcPort = packet.getDestPort();
      this.outDestPort = packet.getSrcPort();
      this.outProtocol = packet.getLayer4Protocol();

      LAYER_4_PROTOCOL protocol = packet.getLayer4Protocol();
      switch (protocol) {
      case TCP:
         this.sessionStatus = SessionStatus.TCP_SYN_INIT;
         break;
      case UDP:
         this.sessionStatus = SessionStatus.UDP_OPEN;
         break;
      default:
         this.sessionStatus = SessionStatus.RAW_IP_OPEN;
         break;
      }
      if (inDestPort == null) {
         this.application = APPLICATION.UNKNOWN_APPLICATION;
         return;
      }
      int destPost = inDestPort.getPortNum();
      switch (destPost) {
      case 21:
         this.application = APPLICATION.FTP;
         return;
      case 23:
         this.application = APPLICATION.TELNET;
         return;
      case 53:
         this.application = APPLICATION.DNS;
         return;
      default:
         this.application = APPLICATION.UNKNOWN_APPLICATION;
         return;
      }
   }

   /**
    * According to the input packet, create a session item.
    * 
    * @param packet
    * @return
    */
   public static SessionItem createSessionItem(Packet packet) {
      if (packet.getL4() == null) {
         // If packet has no layer 4, do not create session item.
         return null;
      }

      SessionItem result = new SessionItem(packet);
      // set input info
      return result;
   }

   /**
    * Check if one packet matches the session item, if match return true, else
    * return false
    * 
    * @param packet
    * @return
    */
   public boolean match(Packet packet) {
      if (inSrcIpv4Address.equals(packet.getSrcIp())
            && inDestIpv4Address.equals(packet.getDestIp())) {
         // compare the in
         if (inSrcPort == null && inDestPort == null) {
            return packet.getSrcPort() == null && packet.getDestPort() == null;
         } else if (inSrcPort == null || inDestPort == null) {
            return false;
         } else {
            return inSrcPort.equals(packet.getSrcPort())
                  && inDestPort.equals(packet.getDestPort());
         }
      } else if (outSrcIpv4Address.equals(packet.getSrcIp())
            && outDestIpv4Address.equals(packet.getDestIp())) {
         // compare the out
         if (outSrcPort == null && outDestPort == null) {
            return packet.getSrcPort() == null && packet.getDestPort() == null;
         } else if (outSrcPort == null || outDestPort == null) {
            return false;
         } else {
            return outDestPort.equals(packet.getDestPort())
                  && outSrcPort.equals(packet.getSrcPort());
         }
      }
      return false;
   }

   /**
    * Get session item's detail infomation
    * 
    * @return
    */
   public String toString() {
      StringBuffer sb = new StringBuffer("");
      sb.append("In Source Ip Address: ");
      sb.append(inSrcIpv4Address.getPointString());
      sb.append("  ");
      if (inSrcPort != null)
         sb.append(inSrcPort.toString());
      sb.append("\n");

      sb.append("In Destination Ip Address: ");
      sb.append(inDestIpv4Address.getPointString());
      sb.append("  ");
      if (inDestPort != null)
         sb.append(inDestPort.toString());
      sb.append("\n");
      sb.append("Packet In Protocol: ");
      sb.append(inProtocol.toString());
      sb.append("\n");

      sb.append("Out Source Ip Address: ");
      sb.append(outSrcIpv4Address.getPointString());
      sb.append("  ");
      if (outSrcPort != null)
         sb.append(outSrcPort.toString());
      sb.append("\n");

      sb.append("Out Destination Ip Address: ");
      sb.append(outDestIpv4Address.getPointString());
      sb.append("  ");
      if (outDestPort != null)
         sb.append(outDestPort.toString());
      sb.append("\n");
      sb.append("Packet Out Protocol: ");
      sb.append(outProtocol.toString());
      sb.append("\n");
      sb.append("Session State: ");
      sb.append(sessionStatus.toString());
      sb.append("\n");
      sb.append("Application: ");
      sb.append(application.toString());
      sb.append("\n");

      return sb.toString();
   }

   public LAYER_4_PROTOCOL getInProtocol() {
      return inProtocol;
   }

   public LAYER_4_PROTOCOL getOutProtocol() {
      return outProtocol;
   }

   public APPLICATION getApplication() {
      return application;
   }

   public Ipv4Address getOutSrcIpv4Address() {
      return outSrcIpv4Address;
   }

   public Port getOutSrcPort() {
      return outSrcPort;
   }

   public Ipv4Address getOutDestIpv4Address() {
      return outDestIpv4Address;
   }

   public Port getOutDestPort() {
      return outDestPort;
   }

   public Ipv4Address getInSrcIpv4Address() {
      return inSrcIpv4Address;
   }

   public Port getInSrcPort() {
      return inSrcPort;
   }

   public Ipv4Address getInDestIpv4Address() {
      return inDestIpv4Address;
   }

   public Port getInDestPort() {
      return inDestPort;
   }

   public SessionStatus getSessionStatus() {
      return sessionStatus;
   }
}
