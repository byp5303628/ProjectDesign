package project.protocol.datagram.layer2.ethernet;


import org.testng.Assert;
import org.testng.annotations.Test;

import project.protocol.datagram.layer2.ethernet.MacAddress;

public class MacAddressTest {
   @Test
   public void testMacAddress() {
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
