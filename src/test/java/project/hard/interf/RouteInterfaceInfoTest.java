package project.hard.interf;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.InvalidPointStringException;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.header.Packet;
import project.protocol.header.layer3.Arp;

public class RouteInterfaceInfoTest {
   @Test
   public void testSetValidIpv4Address() throws InvalidPointStringException {
      RouteInterfaceInfo ri = new RouteInterfaceInfo();
      ri.setIpv4Address("192.168.1.1");

   }

   @Test(expectedExceptions = InvalidPointStringException.class)
   public void testSetInvalidIpv4Address1() throws InvalidPointStringException {
      RouteInterfaceInfo ri = new RouteInterfaceInfo();
      ri.setIpv4Address("192.168.11");
   }

   @Test(expectedExceptions = InvalidPointStringException.class)
   public void testSetInvalidIpv4Address2() throws InvalidPointStringException {
      RouteInterfaceInfo ri = new RouteInterfaceInfo();
      ri.setIpv4Address("192.168.11.256");
   }

   @Test
   public void testSendArpRequest() {
      RouteInterfaceInfo r = new RouteInterfaceInfo();
      Packet p = r.sendArpRequest(new Ipv4Address());
      Assert.assertEquals(p.getLayer3(), "ARP");
      Arp a = (Arp) p.getL3();
      Assert.assertTrue(a.isRequest());      
   }
}
