package project.protocol.header;

import project.protocol.datagram.layer2.FrameType;
import project.protocol.datagram.layer2.MacAddress;

public class Ethernet {
   private MacAddress srcMac;
   private MacAddress destMac;
   private FrameType frameType;

   public Ethernet() {
   }

   public MacAddress getSrcMac() {
      return srcMac;
   }

   public void setSrcMac(MacAddress srcMac) {
      this.srcMac = srcMac;
   }

   public MacAddress getDestMac() {
      return destMac;
   }

   public void setDestMac(MacAddress destMac) {
      this.destMac = destMac;
   }

   public FrameType getFrameType() {
      return frameType;
   }

   public void setFrameType(FrameType frameType) {
      this.frameType = frameType;
   }
}
