package project.protocol.datagram.layer3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Ipv4AddressTest {
   @Test
   public void testSetAndGet() {
      Ipv4Address ip = new Ipv4Address();
      Assert.assertEquals(ip.getIp(), "c0a80101");
      ip.setIp("01010101");
      Assert.assertEquals(ip.getIp(), "01010101");
   }
   
   @Test
   public void testPointString(){
      Ipv4Address ip = new Ipv4Address();
      Assert.assertEquals(ip.getPointString(), "192.168.1.1");
      ip.setPointString("1.1.1.1");
      Assert.assertEquals(ip.getIp(), "01010101");
   }
}