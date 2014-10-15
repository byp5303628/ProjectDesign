package project.hard.interf;

import project.exceptions.InvalidPointStringException;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;

public class RouteInterfaceInfo extends InterfaceInfo {
   private Ipv4Address ipv4Address;

   public RouteInterfaceInfo() {
      this.setMode(Mode.Route);
      this.setAddr(MacAddress.makeMacAddress());
      this.ipv4Address = new Ipv4Address();
   }

   /**
    * Set the ipv4 address of this interface
    * 
    * @param pointString
    *           , which is the point string like 192.168.1.1
    * @throws InvalidPointStringException
    */
   public void setIpv4Address(String pointString)
         throws InvalidPointStringException {
      this.ipv4Address.setPointString(pointString);
   }

   /**
    * If this ip address is destination
    * 
    * @param ip
    *           , which is the ip you want to check
    * @return
    */
   public boolean isIpEqual(Ipv4Address ip) {
      return this.ipv4Address.equals(ip);
   }

   public String toString() {
      return null;
   }
}
