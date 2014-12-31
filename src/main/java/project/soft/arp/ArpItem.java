package project.soft.arp;

import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;


/**
 * Created by ypbai on 2014/12/25.
 */
public class ArpItem {
   private Ipv4Address ip;
   private MacAddress mac;


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
      if (o == null)
         return false;
      if (!ip.equals(((ArpItem) o).getIp()))
         return false;
      if (!mac.equals(((ArpItem) o).getMac()))
         return false;
      return true;
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