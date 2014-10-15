package project.protocol.header.layer2.ethernet;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.InvalidFrameType;
import project.exceptions.InvalidMacAddressException;
import project.protocol.header.layer2.Ethernet;

public class EthernetTest {
   @Test
   public void testToString() throws InvalidMacAddressException, InvalidFrameType {
      Ethernet e = new Ethernet();
      Assert.assertEquals(e.toString(), "0000000000000000000000000800");
   }
}