package project.protocol.datagram.layer3.ip;

import project.exceptions.InvalidPointStringException;
import project.soft.util.RangeInter;


public class Ipv4Address implements RangeInter<Ipv4Address> {
   /*
    * The core part of the ip header
    * it's a 32 bit datagram.
    */
   private final static String POINT_STRING_PATTERN =
         "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";

   private String ip;

   public Ipv4Address(String ip) {
      this.ip = ip;
   }

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

   public void setPointString(String input) throws InvalidPointStringException {
      if (!input.matches(POINT_STRING_PATTERN)) {
         throw new InvalidPointStringException(input);
      }
      String[] s = input.split("\\.");
      StringBuffer result = new StringBuffer("");
      for (String sub : s) {
         int num = Integer.parseInt(sub);
         if (15 < num && num <= 255) {
            result.append(Integer.toHexString(num));
         } else if (num <= 15) {
            result.append("0");
            result.append(Integer.toHexString(num));
         } else {
            throw new InvalidPointStringException(input);
         }

      }
      this.setIp(result.toString());
   }

   public Integer getIntIp() {
      Integer first = Integer.parseInt(ip.substring(0, 16), 16);
      Integer second = Integer.parseInt(ip.substring(16, 32), 16);

      return first * 65536 + second;
   }

   @Override
   public int hashCode() {
      return ip.hashCode();
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      final Ipv4Address other = (Ipv4Address) obj;
      return this.ip.equals(other.getIp());
   }

   public String toString() {
      return this.ip;
   }

   @Override
   public int compareTo(Ipv4Address o) {
      return getIntIp().compareTo(o.getIntIp());
   }

   @Override
   public Ipv4Address generateRandomItem(Ipv4Address end) {

      return null;
   }
}
