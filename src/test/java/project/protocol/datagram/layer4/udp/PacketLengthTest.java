package project.protocol.datagram.layer4.udp;

import junit.framework.Assert;

import org.testng.annotations.Test;

import project.exceptions.InvalidUdpPacketException;

/**
 * Created by ypbai on 2015/1/5.
 */
public class PacketLengthTest {

   @Test
   public void testPacketLength() throws InvalidUdpPacketException {
      PacketLength pl = new PacketLength();
      Assert.assertEquals(pl.getPacketLength(), 128);

      pl.setPacketLength(65535);
      Assert.assertEquals(pl.getPacketLength(), 65535);
   }

   @Test(expectedExceptions = InvalidUdpPacketException.class)
   public void testSetter() throws InvalidUdpPacketException {
      PacketLength pl = new PacketLength(65536);
      Assert.assertEquals(pl.getPacketLength(), -1);
   }

   @Test(expectedExceptions = InvalidUdpPacketException.class)
   public void testSetterTwo() throws InvalidUdpPacketException {
      PacketLength pl = new PacketLength();
      pl.setPacketLength(7);
   }
}
