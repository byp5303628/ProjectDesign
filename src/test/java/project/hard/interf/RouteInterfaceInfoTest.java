package project.hard.interf;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.BoardExistingException;
import project.exceptions.InterfaceNotExistException;
import project.exceptions.InvalidPointStringException;
import project.exceptions.SlotNotExistException;
import project.hard.MachineFrame;
import project.hard.board.Board;
import project.hard.board.InterfaceBoard;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.InternetType;
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
      InterfaceBoard board = new InterfaceBoard();
      try {
         mf.insertBoard(0, board);
      } catch (BoardExistingException e) {
         e.printStackTrace();
      } catch (SlotNotExistException e) {
         e.printStackTrace();
      }
      RouteInterfaceInfo ri = null;
      try {
         ri = (RouteInterfaceInfo) board.getInterface(0);
      } catch (InterfaceNotExistException e) {
         e.printStackTrace();
      }
      ri.setIpv4Address("192.168.1.1", 24);
      board.setInterface(0, ri);
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
