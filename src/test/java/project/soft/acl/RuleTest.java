package project.soft.acl;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.InvalidPointStringException;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.datagram.layer4.Port;
import project.protocol.header.Packet;
import project.protocol.header.PacketConstant;
import project.protocol.header.layer3.Ip;
import project.protocol.header.layer4.Udp;

/**
 * Created by ypbai on 2015/3/20.
 */
public class RuleTest {
   @Test
   public void testRuleBasic() throws InvalidPointStringException {
      Ipv4Address start = null;
      Ipv4Address end = null;
      Ipv4Address startDest = null;
      Ipv4Address endDest = null;
      try {
         start = Ipv4Address.makeIpThroughPointString("1.1.1.1");
         end = Ipv4Address.makeIpThroughPointString("1.1.1.10");
         startDest = Ipv4Address.makeIpThroughPointString("2.2.2.1");
         endDest = Ipv4Address.makeIpThroughPointString("2.2.2.10");
      } catch (InvalidPointStringException e) {
         e.printStackTrace();
      }

      Rule.RuleBuilder rb =
            new Rule.RuleBuilder().setSrcIpRange(start, end).setDestIpRange(
                  startDest, endDest);

      Rule r = Rule.makeRuleThroughString(5);
      r.setRb(rb);

      Packet packet =
            Packet.makePacket(PacketConstant.ETHERNET_IP_PACKET
                  + PacketConstant.UDP_IP_PACKET + PacketConstant.UDP_HEADER);

      Ip ip = new Ip();
      ip.setSrcAddr(Ipv4Address.makeIpThroughPointString("1.1.1.4"));
      ip.setDestAddr(Ipv4Address.makeIpThroughPointString("2.2.2.5"));
      packet.setL3(ip);

      Assert.assertTrue(r.match(packet));

      ip.setSrcAddr(Ipv4Address.makeIpThroughPointString("1.1.1.15"));
      packet.setL3(ip);
      Assert.assertFalse(r.match(packet));
   }

   @Test
   public void testRuleBasic2() {
      Port start = new Port(10);
      Port end = new Port(20);
      Port startDest = new Port(100);
      Port endDest = new Port(200);

      Rule.RuleBuilder rb =
            new Rule.RuleBuilder().setSrcPortRange(start, end)
                  .setDestPortRange(startDest, endDest);

      Packet packet =
              Packet.makePacket(PacketConstant.ETHERNET_IP_PACKET
                      + PacketConstant.UDP_IP_PACKET + PacketConstant.UDP_HEADER);

      Rule r = Rule.makeRuleThroughString(5);
      r.setRb(rb);

      Udp udp = new Udp();
      udp.setSrcPort(new Port(15));
      udp.setDestPort(new Port(180));
      packet.setL4(udp);

      Assert.assertTrue(r.match(packet));

      udp.setDestPort(new Port(210));
      Assert.assertFalse(r.match(packet));
   }
}
