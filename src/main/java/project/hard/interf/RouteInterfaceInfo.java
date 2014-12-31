package project.hard.interf;

import project.exceptions.InvalidPointStringException;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.header.Packet;
import project.protocol.header.layer2.Ethernet;
import project.protocol.header.layer3.Arp;

public class RouteInterfaceInfo extends InterfaceInfo {
   private Ipv4Address ipv4Address;

   public RouteInterfaceInfo() {
      this.setMode(Mode.Route);
      this.setAddr(MacAddress.makeMacAddress());
      this.ipv4Address = new Ipv4Address();
   }

   /**
    * Create a packet which is an arp request, includes L2 for ethernet
    *
    * @param target
    *           , which is the dest ip we want to get its mac address
    * @return
    */
   public Packet sendArpRequest(Ipv4Address target) {
      Packet p = new Packet();
      Ethernet e = Ethernet.makeArpEthernet();
      e.setSrcMac(this.getAddr());
      p.setL2(e);
      Arp arp = Arp.makeArpRequest();
      arp.setSendIp(this.ipv4Address);
      arp.setRecvIp(target);
      p.setL3(arp);
      return p;
   }

   /**
    * First send Arp request to LinkedTo interface, and get Arp response, wait
    * for 5 seconds, if not get response, return null
    *
    * @return
    */
   public Arp processArpToBroadcast(Ipv4Address target) {
      // send arp request
      Packet p = this.sendArpRequest(target);
      this.getLinkedTo().processPacket(p);
      return null;
   }

   /**
    * Set the ipv4 address of this interface, at the same time update the
    * routing table for direct type routing item
    *
    * @param pointString
    *           , which is the point string like 192.168.1.1
    * @param mask
    *           , which is the mask of the ip address
    * @throws InvalidPointStringException
    */
   public void setIpv4Address(String pointString, int mask)
         throws InvalidPointStringException {
      this.ipv4Address.setPointString(pointString);
      return;
   }

   /**
    * If this ip address is destination
    *
    * @param ip
    *           , which is the ip you want to check
    * @return
    */
   public boolean isIpEqual(Ipv4Address ip) {
      return this.ipv4Address.equals(ip);
   }

   public String toString() {
      return null;
   }

   @Override
   public void handleOut(Packet packet) {
      // (TODO: Ethan)
   }
}
