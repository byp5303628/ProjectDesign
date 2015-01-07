package project.soft.session;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.protocol.datagram.layer4.Port;
import project.protocol.header.Packet;
import project.protocol.header.PacketConstant;
import project.protocol.header.layer4.APPLICATION;
import project.protocol.header.layer4.LAYER_4_PROTOCOL;
import project.protocol.header.layer4.Udp;

import java.util.HashMap;

/**
 * Created by ypbai on 2015/1/7.
 */
public class SessionItemTest {
   @Test
   public void testConstructor1() {
      String udpPacket =
            PacketConstant.ETHERNET_IP_PACKET
                  + PacketConstant.UDP_IP_PACKET + PacketConstant.UDP_HEADER;
      Packet packet = Packet.makePacket(udpPacket);
      SessionItem si = SessionItem.createSessionItem(packet);

      Assert.assertEquals(si.getApplication(), APPLICATION.UNKNOWN_APPLICATION);
      Assert.assertEquals(si.getInProtocol(), LAYER_4_PROTOCOL.UDP);
      Assert.assertEquals(si.getOutProtocol(), LAYER_4_PROTOCOL.UDP);
      Assert.assertEquals(si.getOutSrcIpv4Address(), packet.getDestIp());
      Assert.assertEquals(si.getOutDestIpv4Address(), packet.getSrcIp());
      Assert.assertEquals(si.getOutDestPort(), packet.getSrcPort());
      Assert.assertEquals(si.getOutSrcPort(), packet.getDestPort());
      Assert.assertEquals(si.getInSrcIpv4Address(), packet.getSrcIp());
      Assert.assertEquals(si.getInDestIpv4Address(), packet.getDestIp());
      Assert.assertEquals(si.getInSrcPort(), packet.getSrcPort());
      Assert.assertEquals(si.getInDestPort(), packet.getDestPort());
      Assert.assertEquals(si.getSessionStatus(), SessionStatus.UDP_OPEN);
   }

   @Test
   public void testConstructor2() {
      String tcpPacket =
              PacketConstant.ETHERNET_IP_PACKET
                      + PacketConstant.TCP_IP_PACKET + PacketConstant.TCP_HEADER;
      Packet packet = Packet.makePacket(tcpPacket);
      SessionItem si = SessionItem.createSessionItem(packet);

      Assert.assertEquals(si.getApplication(), APPLICATION.UNKNOWN_APPLICATION);
      Assert.assertEquals(si.getInProtocol(), LAYER_4_PROTOCOL.TCP);
      Assert.assertEquals(si.getOutProtocol(), LAYER_4_PROTOCOL.TCP);
      Assert.assertEquals(si.getOutSrcIpv4Address(), packet.getDestIp());
      Assert.assertEquals(si.getOutDestIpv4Address(), packet.getSrcIp());
      Assert.assertEquals(si.getOutDestPort(), packet.getSrcPort());
      Assert.assertEquals(si.getOutSrcPort(), packet.getDestPort());
      Assert.assertEquals(si.getInSrcIpv4Address(), packet.getSrcIp());
      Assert.assertEquals(si.getInDestIpv4Address(), packet.getDestIp());
      Assert.assertEquals(si.getInSrcPort(), packet.getSrcPort());
      Assert.assertEquals(si.getInDestPort(), packet.getDestPort());
      Assert.assertEquals(si.getSessionStatus(), SessionStatus.TCP_SYN_INIT);
   }

   @Test
   public void testConstructor3() {
      String rawIpPacket =
              PacketConstant.ETHERNET_IP_PACKET
                      + PacketConstant.RAW_IP_PACKET;
      Packet packet = Packet.makePacket(rawIpPacket);
      SessionItem si = SessionItem.createSessionItem(packet);

      Assert.assertNull(si);
   }

   @Test
   public void testConstructor4() {
      String udpPacket =
              PacketConstant.ETHERNET_IP_PACKET
                      + PacketConstant.UDP_IP_PACKET + PacketConstant.UDP_HEADER;
      Packet packet = Packet.makePacket(udpPacket);
      Udp udp = (Udp) packet.getL4();
      udp.setDestPort(new Port(21));
      packet.setL4(udp);
      SessionItem si = SessionItem.createSessionItem(packet);
      Assert.assertEquals(si.getApplication(), APPLICATION.FTP);
      udp.setDestPort(new Port(23));
      packet.setL4(udp);
      si = SessionItem.createSessionItem(packet);
      Assert.assertEquals(si.getApplication(), APPLICATION.TELNET);
      udp.setDestPort(new Port(53));
      packet.setL4(udp);
      si = SessionItem.createSessionItem(packet);
      Assert.assertEquals(si.getApplication(), APPLICATION.DNS);
   }

   @Test
   public void testToString() {
      String udpPacket =
              PacketConstant.ETHERNET_IP_PACKET
                      + PacketConstant.UDP_IP_PACKET + PacketConstant.UDP_HEADER;
      Packet packet = Packet.makePacket(udpPacket);
      SessionItem si = SessionItem.createSessionItem(packet);
      System.out.println(si.toString());
   }
}
