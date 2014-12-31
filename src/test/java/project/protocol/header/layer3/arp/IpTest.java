package project.protocol.header.layer3.arp;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.protocol.header.layer3.Ip;

public class IpTest {
   @Test
   public void testValidMatchRoute() {
      Ip ip = new Ip();
      Assert.assertEquals(ip.toString(),
            "4500001400000000ff010000c0a80101c0a80101");
   }
}
