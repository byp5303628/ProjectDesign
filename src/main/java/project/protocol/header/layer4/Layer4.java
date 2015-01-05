package project.protocol.header.layer4;

import project.protocol.datagram.layer4.Port;

public abstract class Layer4 {
   private Port srcPort;
   private Port destPort;

   public Port getSrcPort() {
      return srcPort;
   }

   public void setSrcPort(Port srcPort) {
      this.srcPort = srcPort;
   }

   public Port getDestPort() {
      return destPort;
   }

   public void setDestPort(Port destPort) {
      this.destPort = destPort;
   }
}
