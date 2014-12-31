package project.soft.route;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.InvalidPointStringException;
import project.hard.interf.InterfaceInfo;
import project.hard.interf.RouteInterfaceInfo;
import project.protocol.datagram.layer3.ip.Ipv4Address;

public class RouteTableTest {
   @Test
   public void testValidInsertRouteItem() throws InvalidPointStringException {
      RouteTable rt = new RouteTable();
      InterfaceInfo inter = new RouteInterfaceInfo();
      inter.setName("my interface1");

      Ipv4Address target = new Ipv4Address();
      target.setPointString("1.1.1.1");
      int mask = 24;
      String type = "static";
      rt.insertRouteItem(target, mask, type, inter);

      Ipv4Address tar1 = new Ipv4Address();
      InterfaceInfo inter1 = new RouteInterfaceInfo();
      inter1.setName("my interface2");
      tar1.setPointString("1.1.3.1");
      rt.insertRouteItem(tar1, mask, type, inter1);

      Ipv4Address tar2 = new Ipv4Address();
      tar2.setPointString("1.1.2.1");
      InterfaceInfo inter2 = new RouteInterfaceInfo();
      inter2.setName("my interface3");
      rt.insertRouteItem(tar2, mask, type, inter2);

      Ipv4Address ip = new Ipv4Address();
      ip.setPointString("1.1.2.100");
      rt.display();

      InterfaceInfo result = rt.getOutputInterface(ip);
      Assert.assertEquals(result.getName(), inter2.getName());
      rt.deleteRouteItem(tar2, 24);
      Assert.assertNull(rt.getOutputInterface(ip));
      rt.display();
   }
}
