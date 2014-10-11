package project.protocol.datagram.layer2;


import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.InvalidMacAddressException;
import project.protocol.datagram.layer2.MacAddress;

public class MacAddressTest {
   @Test
   public void testMacAddress() throws InvalidMacAddressException {
      MacAddress mac1 = new MacAddress();
      MacAddress mac2 = new MacAddress();
      mac2.setAddr("FFFFFFFFFFFF");
      mac1.setAddr("FFFFFFFFffff");
      Assert.assertTrue(mac1.equals(mac2));
      Assert.assertTrue(mac1.isBroadcast());
      MacAddress mac3 = new MacAddress();
      Assert.assertEquals(mac3.getAddr(), "000000000000");
   }
}
