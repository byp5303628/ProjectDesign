package project.hard.interf;

import project.protocol.datagram.layer2.ethernet.MacAddress;

public class BridgeInterfaceInfo extends InterfaceInfo {
   BridgeInterfaceInfo() {
      this.setMode(Mode.Bridge);
      this.setMacAddress(MacAddress.makeMacAddress());
      this.setIpv4Address(null);
   }
}
