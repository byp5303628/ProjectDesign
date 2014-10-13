package project.protocol.header.layer2;

import project.exceptions.InvalidFrameType;
import project.exceptions.InvalidMacAddressException;
import project.protocol.datagram.layer2.ethernet.FrameType;
import project.protocol.datagram.layer2.ethernet.MacAddress;

public class Ethernet extends Layer2 {
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
