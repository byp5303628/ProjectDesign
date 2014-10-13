package project.protocol.datagram.layer3;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.TotalLengthException;

public class TotalLengthTest {
   @Test
   public void testGetAndSet() throws TotalLengthException {
      TotalLength t = new TotalLength();
      Assert.assertEquals(t.getTotalLength(), 20);
      t.setTotalLength(65534);
      Assert.assertEquals(t.getTotalLength(), 65534);
   }

   @Test(expectedExceptions = TotalLengthException.class)
   public void testSetThrowException1() throws TotalLengthException {
      TotalLength t = new TotalLength();
      t.setTotalLength(19);
   }

   @Test(expectedExceptions = TotalLengthException.class)
   public void testSetThrowException2() throws TotalLengthException {
      TotalLength t = new TotalLength();
      t.setTotalLength(65535);
   }
   
   @Test
   public void testToString() throws TotalLengthException {
      TotalLength t = new TotalLength();
      t.setTotalLength(21);
      Assert.assertEquals(t.toString(), "0015");
   }
}
