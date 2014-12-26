package project.protocol.header.layer2.ethernet;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.protocol.header.layer2.Ethernet;

public class EthernetTest {
   @Test
   public void testToString() {
      Ethernet e = new Ethernet();
      Assert.assertEquals(e.toString(), "0000000000000000000000000800");
   }
}
