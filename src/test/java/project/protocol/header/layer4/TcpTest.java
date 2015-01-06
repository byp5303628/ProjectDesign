package project.protocol.header.layer4;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.protocol.datagram.layer3.ip.Checksum;

/**
 * Created by ypbai on 2015/1/6.
 */
public class TcpTest {
   @Test
   public void testConstructor() {
      Tcp tcp = new Tcp();
      Assert.assertEquals(tcp.getStart(), tcp.getEnd());
      Assert.assertFalse(tcp.isAckPacket());
      Assert.assertFalse(tcp.isFinPacket());
      Assert.assertFalse(tcp.isRstPacket());
      Assert.assertFalse(tcp.isSynPacket());

      Assert.assertEquals(tcp.getWindow().getWindow(), "0000");
      Assert.assertEquals(tcp.getChecksum(), new Checksum());
      tcp.setSynPacket();
      Assert.assertTrue(tcp.isSynPacket());
      tcp.setFinPacket();
      Assert.assertTrue(tcp.isFinPacket());
      tcp.setAckPacket();
      Assert.assertTrue(tcp.isAckPacket());
      tcp.setRstPacket();
      Assert.assertTrue(tcp.isRstPacket());
   }
}
