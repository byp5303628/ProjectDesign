package project.protocol.header;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IpTest {
   @Test
   public void testValidMatchRoute() {
      Ip ip = new Ip();
      Assert.assertEquals(ip.toString(),
            "45001400000000ff00010000c0a80101c0a80101");
   }
}
