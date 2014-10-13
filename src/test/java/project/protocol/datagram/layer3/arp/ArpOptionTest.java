package project.protocol.datagram.layer3.arp;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ArpOptionTest {
   @Test
   public void testArpReqResp() {
      ArpOption a = new ArpOption();
      a.arpRequest();
      Assert.assertTrue(a.isArpRequest());
      a.arpResponse();
      Assert.assertTrue(a.isArpResponse());
   }
}
