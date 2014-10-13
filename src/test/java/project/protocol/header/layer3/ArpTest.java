package project.protocol.header.layer3;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.InvalidMacAddressException;

public class ArpTest {
   @Test
   public void testMakeArpReqRecv() throws InvalidMacAddressException {
      Arp a = Arp.makeArpRequest();
      Arp b = Arp.makeArpResponse();
      Assert.assertTrue(a.isRequest());
      Assert.assertTrue(b.isResponse());
   }

   @Test
   public void testToString() throws InvalidMacAddressException {
      Arp a = Arp.makeArpRequest();
      Assert.assertEquals(a.toString(), "0001080006040001ffffffffffffc0a80101000000000000c0a80101");
   }
}
