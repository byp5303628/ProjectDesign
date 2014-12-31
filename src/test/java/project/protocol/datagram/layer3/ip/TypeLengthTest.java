package project.protocol.datagram.layer3.ip;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TypeLengthTest {
   @Test
   public void testGetHeaderLength() {
      TypeLength t = new TypeLength();
      Assert.assertEquals(t.getHeaderLength(), 20);
   }
}
