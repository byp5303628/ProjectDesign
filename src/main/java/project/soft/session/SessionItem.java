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
   private Ipv4Address inSrcIpv4Address;
   private Port inSrcPort;
   private Ipv4Address inDestIpv4Address;
   private Port inDestPort;
   private LAYER_4_PROTOCOL inProtocol;

   private Ipv4Address outSrcIpv4Address;
   private Port outSrcPort;
   private Ipv4Address outDestIpv4Address;
   private Port outDestPort;
   private LAYER_4_PROTOCOL outProtocol;

   private APPLICATION application;
   private SessionStatus sessionStatus;

   private SessionItem() {

   }

   /**
    * According to the input packet, create a session item.
    * 
    * @param packet
    * @return
    */
   public static SessionItem createSessionItem(Packet packet) {
      SessionItem result = new SessionItem();
      // set input info
      result.setInSrcIpv4Address(packet.getSrcIp());
      result.setInDestIpv4Address(packet.getDestIp());
      result.setInSrcPort(packet.getSrcPort());
      result.setInDestPort(packet.getDestPort());
      result.setInProtocol(packet.getLayer4Protocol());

      result.setOutSrcIpv4Address(packet.getDestIp());
      result.setOutDestIpv4Address(packet.getSrcIp());
      result.setOutSrcPort(packet.getDestPort());
      result.setOutDestPort(packet.getSrcPort());
      result.setOutProtocol(packet.getLayer4Protocol());

      LAYER_4_PROTOCOL protocol = packet.getLayer4Protocol();
      switch (protocol) {
      case TCP:
         result.setSessionStatus(SessionStatus.TCP_SYN_INIT);
         break;
      case UDP:
         result.setSessionStatus(SessionStatus.UDP_OPEN);
         break;
      case RAW_IP:
         result.setSessionStatus(SessionStatus.RAW_IP_OPEN);
         break;
      default:
         result.setSessionStatus(null);
      }

      result.setApplication();

      return result;
   }

   private void setApplication() {
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
    * Get session item's detail infomation
    * 
    * @return
    */
   public String toString() {
      StringBuffer sb = new StringBuffer("");
      sb.append("In Source Ip Address: ");
      sb.append(inSrcIpv4Address.toString());
      sb.append("  ");
      if (inSrcPort != null)
         sb.append(inSrcPort.toString());

      sb.append("In Destination Ip Address: ");
      sb.append(inDestIpv4Address.toString());
      sb.append("  ");
      if (inDestPort != null)
         sb.append(inDestPort.toString());
      sb.append(getStringFromProtocol(inProtocol));

      sb.append("Out Source Ip Address: ");
      sb.append(outSrcIpv4Address.toString());
      sb.append("  ");
      if (outSrcPort != null)
         sb.append(outSrcPort.toString());

      sb.append("Out Destination Ip Address: ");
      sb.append(outDestIpv4Address.toString());
      sb.append("  ");
      if (outDestPort != null)
         sb.append(outDestPort.toString());
      sb.append(getStringFromProtocol(outProtocol));

      return sb.toString();
   }

   private String getStringFromProtocol(LAYER_4_PROTOCOL protocol) {
      switch (protocol) {
      case UDP:
         return "UDP";
      case TCP:
         return "TCP";
      case RAW_IP:
         return "RAW_IP";
      default:
         return null;
      }
   }

   public LAYER_4_PROTOCOL getInProtocol() {
      return inProtocol;
   }

   public void setInProtocol(LAYER_4_PROTOCOL inProtocol) {
      this.inProtocol = inProtocol;
   }

   public LAYER_4_PROTOCOL getOutProtocol() {
      return outProtocol;
   }

   public void setOutProtocol(LAYER_4_PROTOCOL outProtocol) {
      this.outProtocol = outProtocol;
   }

   public APPLICATION getApplication() {
      return application;
   }

   public void setApplication(APPLICATION application) {
      this.application = application;
   }

   public Ipv4Address getOutSrcIpv4Address() {
      return outSrcIpv4Address;
   }

   public void setOutSrcIpv4Address(Ipv4Address outSrcIpv4Address) {
      this.outSrcIpv4Address = outSrcIpv4Address;
   }

   public Port getOutSrcPort() {
      return outSrcPort;
   }

   public void setOutSrcPort(Port outSrcPort) {
      this.outSrcPort = outSrcPort;
   }

   public Ipv4Address getOutDestIpv4Address() {
      return outDestIpv4Address;
   }

   public void setOutDestIpv4Address(Ipv4Address outDestIpv4Address) {
      this.outDestIpv4Address = outDestIpv4Address;
   }

   public Port getOutDestPort() {
      return outDestPort;
   }

   public void setOutDestPort(Port outDestPort) {
      this.outDestPort = outDestPort;
   }

   public Ipv4Address getInSrcIpv4Address() {
      return inSrcIpv4Address;
   }

   public void setInSrcIpv4Address(Ipv4Address inSrcIpv4Address) {
      this.inSrcIpv4Address = inSrcIpv4Address;
   }

   public Port getInSrcPort() {
      return inSrcPort;
   }

   public void setInSrcPort(Port inSrcPort) {
      this.inSrcPort = inSrcPort;
   }

   public Ipv4Address getInDestIpv4Address() {
      return inDestIpv4Address;
   }

   public void setInDestIpv4Address(Ipv4Address inDestIpv4Address) {
      this.inDestIpv4Address = inDestIpv4Address;
   }

   public Port getInDestPort() {
      return inDestPort;
   }

   public void setInDestPort(Port inDestPort) {
      this.inDestPort = inDestPort;
   }

   public SessionStatus getSessionStatus() {
      return sessionStatus;
   }

   public void setSessionStatus(SessionStatus sessionStatus) {
      this.sessionStatus = sessionStatus;
   }
}
