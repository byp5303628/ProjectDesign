package project.protocol.datagram.layer2.ethernet;


public class FrameType {
   /*
    * The detailed information for the TypeLength, it's 16 bits or 32 bits.
    */

   private String frameType;

   public FrameType() {
      this.setFrameType("0800");
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
}
