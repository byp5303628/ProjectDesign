package project.protocol.header;

import project.protocol.datagram.layer2.ethernet.FrameType;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.arp.*;
import project.protocol.datagram.layer3.ip.*;
import project.protocol.datagram.layer4.Port;
import project.protocol.header.layer2.Ethernet;
import project.protocol.header.layer2.Layer2;
import project.protocol.header.layer3.Arp;
import project.protocol.header.layer3.Ip;
import project.protocol.header.layer3.LAYER_3_PROTOCOL;
import project.protocol.header.layer3.Layer3;
import project.protocol.header.layer4.*;

public class Packet {
   private Layer2 l2;
   private Layer3 l3;
   private Layer4 l4;

   private static final int ETHERNET_SIZE = 28;
   private static final int IP_SIZE = ETHERNET_SIZE + 40;
   private static final int ARP_SIZE = ETHERNET_SIZE + 56;
   private static final int UDP_SIZE = IP_SIZE + 16;
   private static final int TCP_SIZE = IP_SIZE + 40;

   /**
    * Construct a packet only with Hex string. Only support ip and arp packet.
    * 
    * @param s
    * @return
    */
   public static Packet makePacket(String s) {
      Packet packet = new Packet();
      Ethernet e = new Ethernet();
      MacAddress dest = new MacAddress(s.substring(0, 12));
      MacAddress src = new MacAddress(s.substring(12, 24));
      FrameType ft = new FrameType(s.substring(24, 28));
      e.setDestMac(dest);
      e.setSrcMac(src);
      e.setFrameType(ft);
      packet.setL2(e);
      if (e.getNextProtocol().equals(LAYER_3_PROTOCOL.IP)) {
         Ip ip = new Ip();
         ip.setTypeLength(new TypeLength(s.substring(28, 30)));
         ip.setTos(new Tos(s.substring(30, 32)));
         ip.setTotalLength(new TotalLength(s.substring(32, 36)));
         ip.setIdentification(new Identification(s.substring(36, 40)));
         ip.setFlagFragment(new FlagFragment(s.substring(40, 44)));
         ip.setTtl(new Ttl(s.substring(44, 46)));
         ip.setInternetType(new InternetType(s.substring(46, 48)));
         ip.setChecksum(new Checksum(s.substring(48, 52)));
         ip.setSrcAddr(new Ipv4Address(s.substring(52, 60)));
         ip.setDestAddr(new Ipv4Address(s.substring(60, 68)));
         packet.setL3(ip);
         if (s.length() == IP_SIZE) {
            return packet;
         } else if (s.length() == UDP_SIZE) {
            Udp udp = new Udp(s.substring(IP_SIZE, UDP_SIZE));
            packet.setL4(udp);
            return packet;
         } else if (s.length() == TCP_SIZE) {
            Tcp tcp = new Tcp(s.substring(IP_SIZE, TCP_SIZE));
            packet.setL4(tcp);
            return packet;
         }
      } else if (e.getNextProtocol().equals(LAYER_3_PROTOCOL.ARP)
            && s.length() == ARP_SIZE) {
         Arp arp = new Arp();
         arp.setHardwareType(new HardwareType(s.substring(28, 32)));
         arp.setProtocolType(new ProtocolType(s.substring(32, 36)));
         arp.setHardwareLength(new HardwareLength(s.substring(36, 38)));
         arp.setProtocolLength(new ProtocolLength(s.substring(38, 40)));
         arp.setArpOption(new ArpOption(s.substring(40, 44)));
         arp.setSendMac(new MacAddress(s.substring(44, 56)));
         arp.setSendIp(new Ipv4Address(s.substring(56, 64)));
         arp.setRecvMac(new MacAddress(s.substring(64, 76)));
         arp.setRecvIp(new Ipv4Address(s.substring(76, 84)));
         packet.setL3(arp);
      }

      return packet;
   }

   /**
    * Check if this packet is a Ip packet. Mainly used in session table.
    * 
    * @return true if it is an ip packet, false if it's not
    */
   public boolean isIpPacket() {
      if (getLayer3().equals(LAYER_3_PROTOCOL.IP)) {
         return true;
      }
      return false;
   }

   /**
    * If this packet is a Ip packet, get the src port, else return null.
    * 
    * @return
    */
   public Port getSrcPort() {
      if (l4 != null && isIpPacket()) {
         return ((PortLayer) l4).getSrcPort();
      }
      return null;
   }

   /**
    * If this packet is a Ip packet, get the dest port, else return null.
    * 
    * @return
    */
   public Port getDestPort() {
      if (l4 != null && isIpPacket()) {
         return ((PortLayer) l4).getDestPort();
      }
      return null;
   }

   /**
    * If this packet is a Ip packet, get the layer4 protocol, else return null.
    * 
    * @return
    */
   public LAYER_4_PROTOCOL getLayer4Protocol() {
      if (l3 != null && isIpPacket() && l3 instanceof Ip) {
         return ((Ip) l3).getInternetType().getNextProtocol();
      }
      return null;
   }

   /**
    * Check if the packet is an arp request.
    *
    * @return
    */
   public boolean isArpRequest() {
      if ((getLayer3().equals(LAYER_3_PROTOCOL.ARP) && ((Arp) l3).isRequest()))
         return true;
      else
         return false;
   }

   /**
    * Check the layer3's protocol
    *
    * @return
    */
   public LAYER_3_PROTOCOL getLayer3() {
      return l2.getNextProtocol();
   }

   /**
    * Check if the pack is a braodcast packet
    *
    * @return
    */
   public boolean isBroadcast() {
      return this.getDestMac().isBroadcast();
   }

   /**
    * Get the packet's Dest mac
    *
    * @return
    */
   public MacAddress getDestMac() {
      return ((Ethernet) (this.l2)).getDestMac();
   }

   /**
    * Get the packet's Src mac.
    *
    * @return
    */
   public MacAddress getSrcMac() {
      return ((Ethernet) l2).getSrcMac();
   }

   /**
    * Get the packet's Src ip address
    * 
    * @return
    */
   public Ipv4Address getSrcIp() {
      if (getLayer3().equals(LAYER_3_PROTOCOL.IP)) {
         return ((Ip) l3).getSrcAddr();
      }
      return null;
   }

   /**
    * Get the packet's Dest ip address.
    * 
    * @return
    */
   public Ipv4Address getDestIp() {
      if (getLayer3().equals(LAYER_3_PROTOCOL.IP)) {
         return ((Ip) l3).getDestAddr();
      }
      return null;
   }

   public Layer3 getL3() {
      return l3;
   }

   public void setL3(Layer3 l3) {
      this.l3 = l3;
   }

   public Layer2 getL2() {
      return l2;
   }

   public void setL2(Layer2 l2) {
      this.l2 = l2;
   }

   public Layer4 getL4() {
      return l4;
   }

   public void setL4(Layer4 l4) {
      this.l4 = l4;
   }

   public String toString() {
      if (this.l4 == null) {
         String result = this.l2.toString() + this.l3.toString();
         return result;
      } else {
         String result =
               this.l2.toString() + this.l3.toString() + this.l4.toString();
         return result;
      }
   }
}
