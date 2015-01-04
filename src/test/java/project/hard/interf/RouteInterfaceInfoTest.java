package project.hard.interf;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.InvalidPointStringException;
import project.hard.MachineFrame;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.header.Packet;
import project.protocol.header.layer2.Ethernet;
import project.protocol.header.layer3.Arp;
import project.protocol.header.layer3.LAYER_3_PROTOCOL;


public class RouteInterfaceInfoTest {
   @Test
   public void testHandleIn() {
      Packet p = new Packet();
      MacAddress src = MacAddress.makeMacAddress();
      Ethernet e = Ethernet.makeArpEthernet();
      e.setSrcMac(src);

   }

   @Test
   public void testSetValidIpv4Address() throws InvalidPointStringException {
      MachineFrame mf = new MachineFrame();
      RouteInterfaceInfo ri = new RouteInterfaceInfo();
      ri.setIpv4Address("192.168.1.1", 24);
      mf.displayRouteTable();
   }

   @Test(expectedExceptions = InvalidPointStringException.class)
   public void testSetInvalidIpv4Address1() throws InvalidPointStringException {
      RouteInterfaceInfo ri = new RouteInterfaceInfo();
      ri.setIpv4Address("192.168.11", 24);
   }

   @Test(expectedExceptions = InvalidPointStringException.class)
   public void testSetInvalidIpv4Address2() throws InvalidPointStringException {
      RouteInterfaceInfo ri = new RouteInterfaceInfo();
      ri.setIpv4Address("192.168.11.256", 24);
   }

   @Test
   public void testSendArpRequest() {
      RouteInterfaceInfo r = new RouteInterfaceInfo();
      Packet p = r.sendArpRequest(new Ipv4Address());
      Assert.assertEquals(p.getLayer3(), LAYER_3_PROTOCOL.ARP);
      Arp a = (Arp) p.getL3();
      Assert.assertTrue(a.isRequest());
   }
}
