package project.protocol.datagram.layer3;

public class Ipv4Address {
   /*
    * The core part of the ip header
    * it's a 32 bit datagram.
    */

   private String ip;

   public String getIp() {
      return ip;
   }

   public void setIp(String ip) {
      this.ip = ip;
   }

   public String getPointString() {
      return null;
   }

   public void setPointString(String input) {

   }

   public boolean equals(Ipv4Address obj) {
      return this.ip.equals(obj.getIp());
   }
}
