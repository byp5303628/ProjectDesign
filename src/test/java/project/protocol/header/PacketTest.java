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
   @Test
   public void testMakeArpPacket() {
      String arpRequestPacket =
            PacketConstant.ETHERNET_ARP_PACKET
                  + "000108000604000115241515262501010101ffffffffffffffffffff";
      Assert.assertEquals(arpRequestPacket.length(), 84);
      Packet p = Packet.makePacket(arpRequestPacket);
      Assert.assertTrue(p.isArpRequest());
      String arpResponsePacket =
            PacketConstant.ETHERNET_ARP_PACKET
                  + "000208000604000115241515262501010101ffffffffffffffffffff";
      p = Packet.makePacket(arpResponsePacket);
      Assert.assertTrue(p.isBroadcast());
   }

   @Test
   public void testMakeIpPacket() {
      String ipPacket =
            PacketConstant.ETHERNET_IP_PACKET + "4500001400000000ff010000c0a80101c0a80102";
      Assert.assertEquals(ipPacket.length(), 68);
      Packet p = Packet.makePacket(ipPacket);
      Assert.assertEquals(p.isArpRequest(), false);
      Assert.assertEquals(p.isBroadcast(), false);
      Assert.assertEquals(p.getDestMac(), new MacAddress("152415152625"));
   }

   @Test
   public void testIsIpPacket() {
      String ipPacket = PacketConstant.ETHERNET_IP_PACKET + PacketConstant.UDP_IP_PACKET;
      Packet p = Packet.makePacket(ipPacket);
      Assert.assertEquals(p.isIpPacket(), true);
      String arpRequestPacket =
            PacketConstant.ETHERNET_ARP_PACKET
                  + "000108000604000115241515262501010101ffffffffffffffffffff";
      p = Packet.makePacket(arpRequestPacket);
      Assert.assertEquals(p.isIpPacket(), false);
   }

   @Test
   public void testUdpPacket() {
      String udpPacket =
            PacketConstant.ETHERNET_IP_PACKET + PacketConstant.UDP_IP_PACKET + "0400040100800000";
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
            PacketConstant.ETHERNET_IP_PACKET
                  + PacketConstant.TCP_IP_PACKET + "0400040100000000000000000000000000000000";
      Assert.assertEquals(tcpPacket.length(), 108);
      Packet packet = Packet.makePacket(tcpPacket);

      Assert.assertTrue(packet.isIpPacket());
      Assert.assertEquals(packet.getSrcPort(), new Port("0401"));
      Assert.assertEquals(packet.getDestPort(), new Port("0400"));
   }
}
