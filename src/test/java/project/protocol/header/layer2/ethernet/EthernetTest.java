package project.protocol.header.layer2.ethernet;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.protocol.header.layer2.Ethernet;
import project.protocol.header.layer3.LAYER_3_PROTOCOL;

public class EthernetTest {
   @Test
   public void testToString() {
      Ethernet e = new Ethernet();
      Assert.assertEquals(e.toString(), "0000000000000000000000000800");
   }

   @Test
   public void testMakeArpEthernet() {
      Ethernet e = Ethernet.makeArpEthernet();
      Assert.assertEquals(e.getNextProtocol(), LAYER_3_PROTOCOL.ARP);
   }

   @Test
   public void testMakeIpEthernet() {
      Ethernet e = Ethernet.makeIpEthernet();
      Assert.assertEquals(e.getNextProtocol(), LAYER_3_PROTOCOL.IP);
   }
}
