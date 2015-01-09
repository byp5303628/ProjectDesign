package project.protocol.datagram.layer4.udp;

import project.exceptions.InvalidUdpPacketException;

/**
 * Created by ypbai on 2015/1/5.
 */
public class PacketLength {
   private String packetLength;

   public PacketLength(int packetLength) throws InvalidUdpPacketException {
      setPacketLength(packetLength);
   }

   public PacketLength(String packetLength) {
      this.packetLength = packetLength;
   }

   public int getPacketLength() {
      if (packetLength == null) {
         return -1;
      }
      return Integer.parseInt(packetLength, 16);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (!(o instanceof PacketLength))
         return false;

      PacketLength that = (PacketLength) o;

      if (!packetLength.equals(that.packetLength))
         return false;

      return true;
   }

   @Override
   public int hashCode() {
      return packetLength.hashCode();
   }

   public void setPacketLength(int packetLength)
         throws InvalidUdpPacketException {
      if (packetLength < 8 || packetLength > 65535) {
         throw new InvalidUdpPacketException(packetLength);
      }
      this.packetLength = Integer.toHexString(packetLength);
   }

   public PacketLength() throws InvalidUdpPacketException {
      this(128);
   }
}
