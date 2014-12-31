package project.protocol.datagram.layer2.ethernet;


import project.protocol.header.layer3.Layer3Protocol;

public class FrameType {
   /*
    * The detailed information for the TypeLength, it's 16 bits or 32 bits.
    */

   private String frameType;

   public FrameType(String frameType) {
      this.frameType = frameType;
   }

   public FrameType() {
      this("0800");
   }

   /**
    * Make an Arp frame type
    *
    * @return
    */
   public static FrameType makeArpFrameType() {
      FrameType f = new FrameType();
      f.setFrameType("0806");
      return f;
   }

   public static FrameType makeIpFrameType() {
      FrameType f = new FrameType();
      return f;
   }

   public String getFrameType() {
      return frameType;
   }

   public void setFrameType(String frameType) {
      this.frameType = frameType;
   }

   public String toString() {
      return this.frameType;
   }

   public Layer3Protocol getNextProtocol() {
      if (frameType.equals("0806")) {
         return Layer3Protocol.ARP;
      } else if (frameType.equals("0800")) {
         return Layer3Protocol.IP;
      } else {
         return Layer3Protocol.INVALID_PROTOCOL;
      }
   }
}
