package project.hard.interf;

import org.testng.annotations.Test;

import project.exceptions.InvalidPointStringException;

public class RouteInterfaceInfoTest {
   @Test
   public void testSetValidIpv4Address() throws InvalidPointStringException {
      RouteInterfaceInfo ri = new RouteInterfaceInfo();
      ri.setIpv4Address("192.168.1.1");

   }

   @Test(expectedExceptions = InvalidPointStringException.class)
   public void testSetInvalidIpv4Address1() throws InvalidPointStringException {
      RouteInterfaceInfo ri = new RouteInterfaceInfo();
      ri.setIpv4Address("192.168.11");
   }

   @Test(expectedExceptions = InvalidPointStringException.class)
   public void testSetInvalidIpv4Address2() throws InvalidPointStringException {
      RouteInterfaceInfo ri = new RouteInterfaceInfo();
      ri.setIpv4Address("192.168.11.256");
   }


}
