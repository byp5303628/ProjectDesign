package project.hard.interf;

import junit.framework.Assert;
import org.testng.annotations.Test;
import project.exceptions.InvalidPointStringException;
import project.protocol.datagram.layer3.ip.Ipv4Address;

/**
 * Created by ypbai on 2015/1/4.
 */
public class BridgeInterfaceInfoTest {
   @Test
   public void testConstructor() {
      BridgeInterfaceInfo b = new BridgeInterfaceInfo();
      Assert.assertEquals(b.getMode(), InterfaceInfo.Mode.Bridge);
      Assert.assertNull(b.getIpv4Address());
   }

   @Test
   public void testSetIpv4Address() {
      BridgeInterfaceInfo b = new BridgeInterfaceInfo();
      b.setIpv4Address(new Ipv4Address("01010102"));
      Assert.assertNull(b.getIpv4Address());
      try {
         b.setIpv4Address("192.168.1.1", 24);
      } catch (InvalidPointStringException e) {
         e.printStackTrace();
      }
      Assert.assertNull(b.getIpv4Address());
   }
}
