package project.protocol.datagram.layer3;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.protocol.datagram.layer3.ip.TypeLength;

public class TypeLengthTest {
   @Test
   public void testGetHeaderLength() {
      TypeLength t = new TypeLength();
      Assert.assertEquals(t.getHeaderLength(), 20);
   }
}
