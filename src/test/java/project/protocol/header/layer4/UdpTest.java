package project.protocol.header.layer4;

import junit.framework.Assert;
import org.testng.annotations.Test;
import project.exceptions.InvalidUdpPacketException;
import project.protocol.datagram.layer3.ip.Checksum;
import project.protocol.datagram.layer4.udp.PacketLength;

/**
 * Created by ypbai on 2015/1/5.
 */
public class UdpTest {
   @Test
   public void testUdpConstructor() throws InvalidUdpPacketException {
      Udp u = new Udp();
      PacketLength pl = new PacketLength();
      Assert.assertEquals(pl, u.getPacketLength());
      Checksum checksum = new Checksum();
      Assert.assertEquals(checksum, u.getChecksum());
   }
}
