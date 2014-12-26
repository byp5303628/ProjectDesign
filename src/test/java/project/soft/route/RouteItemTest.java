package project.soft.route;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.InvalidPointStringException;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.soft.route.RouteItem;

public class RouteItemTest {
   @Test
   public void testMatch() throws InvalidPointStringException {
      RouteItem ri = new RouteItem();
      ri.setMask(24);
      Ipv4Address ip = new Ipv4Address();
      ip.setPointString("192.168.1.1");
      ri.setTarget(ip);
      ip.setPointString("192.168.1.2");
      Assert.assertTrue(ri.match(ip));
   }
   
   @Test
   public void testNotMatch() throws InvalidPointStringException {
      RouteItem ri = new RouteItem();
      ri.setMask(24);
      Ipv4Address ip = new Ipv4Address();
      Ipv4Address target = new Ipv4Address();
      ip.setPointString("192.168.1.1");
      target.setPointString("192.168.2.2");;
      ri.setTarget(target);
      Assert.assertFalse(ri.match(ip));
   }
   
   @Test
   public void testGetTar(){
      
   }
}
