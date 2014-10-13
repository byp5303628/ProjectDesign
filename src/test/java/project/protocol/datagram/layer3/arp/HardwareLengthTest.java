package project.protocol.datagram.layer3.arp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardwareLengthTest {
   @Test
   public void testGetHardwareLength() {
      HardwareLength hl = new HardwareLength();
      Assert.assertEquals(hl.getHardwareLength(), 48);
   }
}
