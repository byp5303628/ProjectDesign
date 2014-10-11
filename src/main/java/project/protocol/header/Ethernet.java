package project.protocol.header;

import project.exceptions.InvalidFrameType;
import project.exceptions.InvalidMacAddressException;
import project.protocol.datagram.layer2.FrameType;
import project.protocol.datagram.layer2.MacAddress;

public class Ethernet {
   private MacAddress destMac;
   private MacAddress srcMac;
   private FrameType frameType;

   public Ethernet() throws InvalidMacAddressException, InvalidFrameType {
      this.srcMac = new MacAddress();
      this.destMac = new MacAddress();
      this.frameType = new FrameType();
   }

   public String toString() {
      return this.destMac.toString() + this.srcMac.toString()
            + this.frameType.toString();
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
