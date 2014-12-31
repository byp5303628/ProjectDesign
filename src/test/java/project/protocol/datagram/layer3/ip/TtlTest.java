package project.protocol.datagram.layer3.ip;


import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.DestinationNotReachableException;

public class TtlTest {

   @Test
   public void testGoThroughRouter() throws DestinationNotReachableException {
      Ttl t1 = new Ttl();
      t1.setTtl(10);
      Assert.assertEquals(t1.getTtl(), 10);
      t1.goThroughRouter();
      Assert.assertEquals(t1.getTtl(), 9);

   }

   @Test(expectedExceptions = DestinationNotReachableException.class)
   public void testInvalidGoThroughRouter()
         throws DestinationNotReachableException {
      Ttl t1 = new Ttl();
      t1.setTtl(1);
      t1.goThroughRouter();
   }
}
