package project.protocol.header;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.protocol.datagram.layer2.ethernet.MacAddress;

/**
 * Created by ypbai on 2014/12/31.
 */
public class PacketTest {
   private static final String ETHERNET_IP_PACKET =
         "1524151526251524151526270800";
   private static final String ETHERNET_ARP_PACKET =
         "ffffffffffff1524151526250806";

   @Test
   public void testMakeArpPacket() {
      String arpRequestPacket =
            "ffffffffffff1524151526250806000108000604000115241515262501010101ffffffffffffffffffff";
      Assert.assertEquals(arpRequestPacket.length(), 84);
      Packet p = Packet.makePacket(arpRequestPacket);
      Assert.assertTrue(p.isArpRequest());
      String arpResponsePacket =
            "ffffffffffff1524151526250806000208000604000115241515262501010101ffffffffffffffffffff";
      p = Packet.makePacket(arpResponsePacket);
      Assert.assertTrue(p.isBroadcast());
   }

   @Test
   public void testMakeIpPacket() {
      String ipPacket =
            ETHERNET_IP_PACKET + "4500001400000000ff010000c0a80101c0a80102";
      Assert.assertEquals(ipPacket.length(), 68);
      Packet p = Packet.makePacket(ipPacket);
      Assert.assertEquals(p.isArpRequest(), false);
      Assert.assertEquals(p.isBroadcast(), false);
      Assert.assertEquals(p.getDestMac(), new MacAddress("152415152625"));
   }

   @Test
   public void testIsIpPacket() {
      String ipPacket =
            ETHERNET_IP_PACKET + "4500001400000000ff010000c0a80101c0a80102";
      Packet p = Packet.makePacket(ipPacket);
      Assert.assertEquals(p.isIpPacket(), true);
      String arpRequestPacket =
            "ffffffffffff1524151526250806000108000604000115241515262501010101ffffffffffffffffffff";
      p = Packet.makePacket(arpRequestPacket);
      Assert.assertEquals(p.isIpPacket(), false);
   }
}
