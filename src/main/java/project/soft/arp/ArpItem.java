package project.soft.arp;

import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;


/**
 * Created by ypbai on 2014/12/25.
 */
public class ArpItem {
   private Ipv4Address ip;
   private MacAddress mac;

   public ArpItem() {
      this.ip = new Ipv4Address();
      this.mac = new MacAddress();
   }

   public MacAddress getMac() {
      return mac;
   }

   public void setMac(MacAddress mac) {
      this.mac = mac;
   }

   public Ipv4Address getIp() {
      return ip;
   }

   public void setIp(Ipv4Address ip) {
      this.ip = ip;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (!(o instanceof ArpItem))
         return false;

      ArpItem arpItem = (ArpItem) o;

      if (!ip.equals(arpItem.ip))
         return false;
      if (!mac.equals(arpItem.mac))
         return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = ip.hashCode();
      result = 31 * result + mac.hashCode();
      return result;
   }

   public String toString() {
      StringBuffer sb = new StringBuffer("");
      sb.append(ip.getPointString());
      sb.append("    ");
      sb.append(mac.toString());
      sb.append("    ");
      return sb.toString();
   }
}