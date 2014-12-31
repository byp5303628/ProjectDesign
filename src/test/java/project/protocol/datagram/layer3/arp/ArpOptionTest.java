package project.protocol.datagram.layer3.arp;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ArpOptionTest {
   @Test
   public void testArpReqResp() {
      ArpOption a = ArpOption.makeArpRequestOption();
      Assert.assertTrue(a.isArpRequest());
      ArpOption b = ArpOption.makeArpResponseOption();
      Assert.assertTrue(b.isArpResponse());
   }
}
