package project.protocol.datagram.layer3;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import project.exceptions.DestinationNotReachableException;

public class TtlTest {
   @Rule
   public ExpectedException thrown = ExpectedException.none();

   @Test
   public void testGoThroughRouter() throws DestinationNotReachableException {
      Ttl t1 = new Ttl();
      t1.setTtl(10);
      Assert.assertEquals(t1.getTtl(), 10);
      t1.goThroughRouter();
      Assert.assertEquals(t1.getTtl(), 9);

   }

   //@Test
   public void testInvalidGoThroughRouter()
         throws DestinationNotReachableException {
      Ttl t1 = new Ttl();
      t1.setTtl(1);
      try {
         t1.goThroughRouter();
      } catch (Exception e) {
         if (e instanceof DestinationNotReachableException)
            return;
      }
      fail();
   }
}
