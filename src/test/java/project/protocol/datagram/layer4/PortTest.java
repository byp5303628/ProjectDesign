package project.protocol.datagram.layer4;

import junit.framework.Assert;

import org.testng.annotations.Test;

/**
 * Created by ypbai on 2015/1/5.
 */
public class PortTest {
   @Test
   public void testPortNum() {
      Port p = new Port();
      Assert.assertEquals(p.getPortNum(), 1024);
      p.setPort(120);
      Assert.assertEquals(p.getPortNum(), 120);
   }
}
