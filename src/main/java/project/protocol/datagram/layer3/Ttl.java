package project.protocol.datagram.layer3;

import project.exceptions.DestinationNotReachableException;

public class Ttl {
   /*
    * Ipv4 header's 6th part, 8 bits
    * to control how many jumps can it go
    */

   private String ttl;

   public int getTtl() {
      return Integer.parseInt(this.ttl, 16);
   }

   public void setTtl(int num) {
      this.ttl = Integer.toHexString(num);
   }

   public void goThroughRouter() throws DestinationNotReachableException {
      this.decrease();
      if (!this.isAlive()) {
         throw new DestinationNotReachableException();
      }
   }

   private void decrease() {
      int num = this.getTtl();
      num--;
      this.setTtl(num);
   }

   private boolean isAlive() {
      int num = this.getTtl();
      return num > 0;
   }
}
