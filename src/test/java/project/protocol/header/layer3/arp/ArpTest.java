package project.protocol.header.layer3.arp;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.protocol.header.layer3.Arp;

public class ArpTest {
   @Test
   public void testMakeArpReqRecv() {
      Arp a = Arp.makeArpRequest();
      Arp b = Arp.makeArpResponse();
      Assert.assertTrue(a.isRequest());
      Assert.assertTrue(b.isResponse());
   }

   @Test
   public void testToString() {
      Arp a = Arp.makeArpRequest();
      Assert.assertEquals(a.toString(),
            "0001080006040001ffffffffffffc0a80101000000000000c0a80101");
   }
}
