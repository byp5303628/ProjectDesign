package project.hard.interf;

import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.header.Packet;
import project.soft.handle.PacketHandler;
import project.soft.nat.NatConfig;

public class RouteInterfaceInfo extends InterfaceInfo implements PacketHandler {
   private NatConfig natConfig;

   public RouteInterfaceInfo() {
      this.setMode(Mode.Route);
      this.setMacAddress(MacAddress.makeMacAddress());
      this.setIpv4Address(new Ipv4Address());
      natConfig = new NatConfig();
   }

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
}
