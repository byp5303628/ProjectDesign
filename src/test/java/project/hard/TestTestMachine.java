package project.hard;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.hard.interf.InterfaceInfo;
import project.hard.interf.RouteInterfaceInfo;
import project.protocol.header.Packet;
import project.protocol.header.PacketConstant;

/**
 * Created by ypbai on 2015/3/6.
 */
public class TestTestMachine {
   @Test
   public void testBasic() {
      TestMachine tm = new TestMachine();
      InterfaceInfo in = new RouteInterfaceInfo();

      tm.connectInterface(in);

      Assert.assertTrue(tm.isConnected());
      tm.unConnect();
      Assert.assertFalse(tm.isConnected());
   }

   @Test
   public void testSendPacket() {
      Packet p =
            Packet.makePacket(PacketConstant.ETHERNET_IP_PACKET
                  + PacketConstant.UDP_IP_PACKET + PacketConstant.UDP_HEADER);

      TestMachine t1 = new TestMachine();
      TestMachine t2 = new TestMachine();

      t1.connectInterface(t2.getInteface());

      t1.sendPacket(p);

      Assert.assertTrue(t2.receivePacket());
      Assert.assertEquals(t2.getReceivedPacket(), p);

      t2.reset();

      Assert.assertFalse(t2.receivePacket());
      Assert.assertNull(t2.getReceivedPacket());
   }
}
