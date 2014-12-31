package project.hard.interf;

import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.soft.handle.PacketHandler;

public class RouteInterfaceInfo extends InterfaceInfo implements PacketHandler {

   public RouteInterfaceInfo() {
      this.setMode(Mode.Route);
      this.setMacAddress(MacAddress.makeMacAddress());
      this.setIpv4Address(new Ipv4Address());
   }
}
