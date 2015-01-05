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
      result.setOutDestIpv4Address(packet.getDestIp());
      result.setInSrcPort(packet.getSrcPort());
      result.setInDestPort(packet.getDestPort());
      result.setInProtocol(packet.getLayer4Protocol());

      result.setInSrcIpv4Address(packet.getDestIp());
      result.setOutDestIpv4Address(packet.getSrcIp());
      result.setInSrcPort(packet.getDestPort());
      result.setInDestPort(packet.getSrcPort());
      result.setInProtocol(packet.getLayer4Protocol());

      result.setApplication();

      return result;
   }

   private APPLICATION setApplication() {
      if (inDestPort == null) {
         return APPLICATION.UNKNOWN_APPLICATION;
      }
      int destPost = inDestPort.getPortNum();
      switch (destPost) {
      case 21:
         return APPLICATION.FTP;
      case 23:
         return APPLICATION.TELNET;
      case 53:
         return APPLICATION.DNS;
      default:
         return APPLICATION.UNKNOWN_APPLICATION;
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
}
