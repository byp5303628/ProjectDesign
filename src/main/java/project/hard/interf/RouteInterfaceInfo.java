package project.hard.interf;

import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.header.Packet;
import project.protocol.header.layer2.Ethernet;
import project.protocol.header.layer3.Arp;
import project.soft.handle.PacketHandler;
import project.soft.nat.NatConfig;

public class RouteInterfaceInfo extends InterfaceInfo implements PacketHandler {
   private NatConfig natConfig;

   public RouteInterfaceInfo() {
      super();
      this.setMode(Mode.Route);
      this.setMacAddress(MacAddress.makeMacAddress());
      this.setIpv4Address(new Ipv4Address());
      natConfig = new NatConfig();
   }

   @Override
   public void handleIn(Packet packet) {
      if (packet.isBroadcast()) {
         // First if it is a broadcast packet, check if it is a arp request
         if (packet.isArpRequest()) {
            // answer it with self's interface info
            sendArpResponse(packet);
         } else {
            // it's a invalid packet, drop it.
            return;
         }
      } else if (packet.getDestMac().equals(this.getMacAddress())) {
         // This is the destination, send response
         switch (packet.getLayer3()) {
         case ARP:
            // update the arp table and return.
            if (!isValidArpResponsePacket(packet)) {
               return;
            }
            if (getIpv4Address() == null) {
               return;
            }
            this.getBoard().getMachineFrame().updateArpTable(packet);
            return;
         case IP:
            // let the function table do the interactive.
            this.getBoard().getMachineFrame()
                  .forwardThroughSessionTable(packet);
            return;
         case INVALID_PROTOCOL:
            // drop invalid packet
            return;
         }
      } else {
         // drop it
         return;
      }
   }

   @Override
   public void handleOut(Packet packet) {
      this.getLinkedTo().handleIn(packet);
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
      e.setSrcMac(this.getMacAddress());
      p.setL2(e);
      Arp arp = Arp.makeArpRequest();
      arp.setSendIp(this.getIpv4Address());
      arp.setRecvIp(target);
      p.setL3(arp);
      return p;
   }

   /**
    * Create a packet which is an arp response, include L2 for ethernet.
    * 
    * @param packet
    */
   public void sendArpResponse(Packet packet) {
      Packet p = new Packet();
      Ethernet e = Ethernet.makeArpEthernet();
      e.setSrcMac(this.getMacAddress());
      e.setDestMac(packet.getSrcMac());
      p.setL2(e);

      Arp arp = Arp.makeArpResponse();
      arp.setSendIp(((Arp) packet.getL3()).getRecvIp());
      arp.setRecvIp(((Arp) packet.getL3()).getSendIp());
      arp.setSendMac(this.getMacAddress());
      arp.setRecvMac(packet.getSrcMac());
      p.setL3(arp);
      this.handleOut(packet);
   }
}
