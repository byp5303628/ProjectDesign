package project.protocol.datagram.layer2;

import project.exceptions.InvalidFrameType;

public class FrameType {
   /*
    * The detailed information for the TypeLength, it's 16 bits or 32 bits.
    */

   private String frameType;
   private final String INPUT_PATTERN = "[1234567890abcdefABCDEF]{4}";

   public FrameType() throws InvalidFrameType {
      this.setFrameType("0800");
   }

   public String getFrameType() {
      return frameType;
   }

   public void setFrameType(String frameType) throws InvalidFrameType {
      if (frameType.matches(INPUT_PATTERN)) {
         this.frameType = frameType;
      } else {
         throw new InvalidFrameType(frameType);
      }
   }

   public String toString() {
      return this.frameType;
   }
}
