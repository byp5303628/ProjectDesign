package project.protocol.datagram.layer4.tcp;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ypbai on 2015/1/6.
 */
public class TcpInteractiveTest {
   @Test
   public void testFlag() {
      TcpInteractive ti = new TcpInteractive();
      Assert.assertEquals(ti.isAck(), false);
      Assert.assertEquals(ti.isFin(), false);
      Assert.assertEquals(ti.isRst(), false);
      Assert.assertEquals(ti.isSyn(), false);
   }

   @Test
   public void testSetter() {
      TcpInteractive ti = new TcpInteractive();

      ti.setAck();
      Assert.assertTrue(ti.isAck());
      ti.setFin();
      Assert.assertTrue(ti.isFin());
      ti.setSyn();
      Assert.assertTrue(ti.isSyn());
      ti.setRst();
      Assert.assertTrue(ti.isRst());
   }
}
