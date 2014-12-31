package project.soft.arp;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.InvalidPointStringException;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;

/**
 * Created by ypbai on 2014/12/31.
 */
public class ArpItemTest {
   @Test
   public void testEquals() {
      ArpItem a1 = new ArpItem();
      a1.setIp(new Ipv4Address("01010202"));
      MacAddress mac = MacAddress.makeMacAddress();
      a1.setMac(mac);
      ArpItem a2 = null;
      Assert.assertEquals(a1.equals(a2), false);

      a2 = new ArpItem();
      Ipv4Address ip = new Ipv4Address();
      try {
         ip.setPointString("1.1.2.2");
      } catch (InvalidPointStringException e) {
         e.printStackTrace();
      }
      a2.setIp(ip);
      a2.setMac(mac);
      Assert.assertTrue(a1.equals(a2));

      a2.setMac(MacAddress.makeMacAddress());
      Assert.assertEquals(a1.equals(a2), false);

      a2.setIp(new Ipv4Address("11112222"));
      a2.setMac(mac);
      Assert.assertEquals(a1.equals(a2), false);
   }
}
