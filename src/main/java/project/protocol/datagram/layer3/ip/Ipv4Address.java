package project.protocol.datagram.layer3.ip;

public class Ipv4Address {
   /*
    * The core part of the ip header
    * it's a 32 bit datagram.
    */

   private String ip;

   public Ipv4Address() {
      this.ip = "c0a80101";
   }

   public String getIp() {
      return ip;
   }

   public void setIp(String ip) {
      this.ip = ip;
   }

   public String getPointString() {
      int num1 = Integer.parseInt(this.ip.substring(0, 2), 16);
      int num2 = Integer.parseInt(this.ip.substring(2, 4), 16);
      int num3 = Integer.parseInt(this.ip.substring(4, 6), 16);
      int num4 = Integer.parseInt(this.ip.substring(6, 8), 16);
      return num1 + "." + num2 + "." + num3 + "." + num4;
   }

   public void setPointString(String input) {
      String[] s = input.split("\\.");
      String result = "";
      for (String sub : s) {
         int num = Integer.parseInt(sub);
         if (num > 15)
            result += Integer.toHexString(num);
         else
            result = result + '0' + Integer.toHexString(num);
      }
      this.setIp(result);
   }

   public boolean equals(Ipv4Address obj) {
      return this.ip.equals(obj.getIp());
   }

   public String toString() {
      return this.ip;
   }
}
