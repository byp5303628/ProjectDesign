package project.hard.interf;

import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.header.Packet;

public class BridgeInterfaceInfo extends InterfaceInfo {
   BridgeInterfaceInfo() {
      this.setMode(Mode.Bridge);
      this.setMacAddress(MacAddress.makeMacAddress());
      this.setIpv4Address(null);
   }

   public void handleIn(Packet packet) {
      if (packet.getDestMac().equals(getMacAddress())) {
         // This is the destination and it's not a Route interface, so drop it.
         return;
      } else {
         // This is not the destination, forward it through mac table
         getBoard().getMachineFrame().forwardThroughMacTable(packet);
      }
   }
}
