package project.protocol.datagram.layer3;

import project.exceptions.TotalLengthException;

public class TotalLength {
   /*
    * Ipv4 header's third part, 16 bits
    */

   private String totalLength;

   public TotalLength() {
      this.totalLength = "14";
   }

   public int getTotalLength() {
      return Integer.parseInt(this.totalLength, 16);
   }

   public void setTotalLength(int num) throws TotalLengthException {
      if (20 <= num && num < 65535) {
         this.totalLength = Integer.toHexString(num);
         return;
      }
      throw new TotalLengthException(num);
   }
}
