package project.protocol.header;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer4.Port;
import project.protocol.header.layer4.LAYER_4_PROTOCOL;
import project.protocol.header.layer4.Tcp;

/**
 * Created by ypbai on 2014/12/31.
 */
public class PacketTest {
   private static final String ETHERNET_IP_PACKET =
         "1524151526251524151526270800";
   private static final String ETHERNET_ARP_PACKET =
         "ffffffffffff1524151526250806";
   private static final String UDP_IP_PACKET =
         "4500001400000000ff110000c0a80101c0a80102";
   private static final String TCP_IP_PACKET =
         "4500001400000000ff060000c0a80101c0a80102";


   @Test
   public void testMakeArpPacket() {
      String arpRequestPacket =
            ETHERNET_ARP_PACKET
                  + "000108000604000115241515262501010101ffffffffffffffffffff";
      Assert.assertEquals(arpRequestPacket.length(), 84);
      Packet p = Packet.makePacket(arpRequestPacket);
      Assert.assertTrue(p.isArpRequest());
      String arpResponsePacket =
            ETHERNET_ARP_PACKET
                  + "000208000604000115241515262501010101ffffffffffffffffffff";
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
      String ipPacket = ETHERNET_IP_PACKET + UDP_IP_PACKET;
      Packet p = Packet.makePacket(ipPacket);
      Assert.assertEquals(p.isIpPacket(), true);
      String arpRequestPacket =
            ETHERNET_ARP_PACKET
                  + "000108000604000115241515262501010101ffffffffffffffffffff";
      p = Packet.makePacket(arpRequestPacket);
      Assert.assertEquals(p.isIpPacket(), false);
   }

   @Test
   public void testUdpPacket() {
      String udpPacket =
            ETHERNET_IP_PACKET + UDP_IP_PACKET + "0400040100800000";
      Assert.assertEquals(udpPacket.length(), 84);
      Packet p = Packet.makePacket(udpPacket);
      Assert.assertTrue(p.isIpPacket());
      Assert.assertEquals(p.getLayer4Protocol(), LAYER_4_PROTOCOL.UDP);
      Assert.assertEquals(p.getSrcPort(), new Port("0401"));
      Assert.assertEquals(p.getDestPort(), new Port("0400"));
   }

   @Test
   public void testTcpPacket() {
      String tcpPacket =
            ETHERNET_IP_PACKET
                  + TCP_IP_PACKET + "0400040100000000000000000000000000000000";
      Assert.assertEquals(tcpPacket.length(), 108);
      Packet packet = Packet.makePacket(tcpPacket);

      Assert.assertTrue(packet.isIpPacket());
      Assert.assertEquals(packet.getSrcPort(), new Port("0401"));
      Assert.assertEquals(packet.getDestPort(), new Port("0400"));
   }
}
