package project.hard.interf;

import project.protocol.datagram.layer2.ethernet.MacAddress;

public class BridgeInterfaceInfo extends InterfaceInfo {
   BridgeInterfaceInfo() {
      this.setMode(Mode.Bridge);
      this.setAddr(MacAddress.makeMacAddress());
      
   }
}
