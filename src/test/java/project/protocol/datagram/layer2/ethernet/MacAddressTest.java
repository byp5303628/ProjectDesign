package project.protocol.datagram.layer2.ethernet;


import org.testng.Assert;
import org.testng.annotations.Test;

public class MacAddressTest {
   @Test
   public void testMacAddress() {
      MacAddress mac1 = new MacAddress();
      MacAddress mac2 = new MacAddress();
      mac2.setAddr("ffffffffffff");
      mac1.setAddr("ffffffffffff");
      Assert.assertTrue(mac1.equals(mac2));
      Assert.assertTrue(mac1.isBroadcast());
      MacAddress mac3 = new MacAddress();
      Assert.assertEquals(mac3.getAddr(), "000000000000");
   }


}
