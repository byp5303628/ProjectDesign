package project.protocol.datagram.layer2.ethernet;


import project.protocol.header.layer3.LAYER_3_PROTOCOL;

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

   public LAYER_3_PROTOCOL getNextProtocol() {
      if (frameType.equals("0806")) {
         return LAYER_3_PROTOCOL.ARP;
      } else if (frameType.equals("0800")) {
         return LAYER_3_PROTOCOL.IP;
      } else {
         return LAYER_3_PROTOCOL.INVALID_PROTOCOL;
      }
   }
}
