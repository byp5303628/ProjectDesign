package project.protocol.header.layer2;

import project.protocol.datagram.layer2.ethernet.FrameType;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.header.layer3.Layer3Protocol;

public class Ethernet extends Layer2 {
   private MacAddress destMac;
   private MacAddress srcMac;
   private FrameType frameType;

   public Ethernet() {
      this.srcMac = new MacAddress();
      this.destMac = new MacAddress();
      this.frameType = new FrameType();
   }

   public static Ethernet makeArpEthernet() {
      Ethernet e = new Ethernet();
      e.setFrameType(FrameType.makeArpFrameType());
      e.setDestMac(MacAddress.makeBraodcastMacAddress());
      return e;
   }

   public String toString() {
      return this.destMac.toString() + this.srcMac.toString()
            + this.frameType.toString();
   }

   public MacAddress getSrcMac() {
      return srcMac;
   }

   public void setSrcMac(String srcMac) {
      this.srcMac.setAddr(srcMac);
   }

   public void setSrcMac(MacAddress srcMac) {
      this.srcMac = srcMac;
   }

   public MacAddress getDestMac() {
      return destMac;
   }

   public void setDestMac(String destMac) {
      this.destMac.setAddr(destMac);
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

   @Override
   public Layer3Protocol getNextProtocol() {
      return frameType.getNextProtocol();
   }
}
