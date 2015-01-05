package project.protocol.header.layer4;

import project.exceptions.InvalidUdpPacketException;
import project.protocol.datagram.layer3.ip.Checksum;
import project.protocol.datagram.layer4.Port;
import project.protocol.datagram.layer4.udp.PacketLength;

/**
 * Created by ypbai on 2015/1/5.
 */
public class Udp extends Layer4 {
   private PacketLength packetLength;
   private Checksum checksum;

   public Udp() {
      setSrcPort(new Port());
      setDestPort(new Port());
      try {
         packetLength = new PacketLength();
      } catch (InvalidUdpPacketException e) {
         e.printStackTrace();
      }
      checksum = new Checksum();
   }

   /**
    * Construct a udp header from string.
    * 
    * @param s
    */
   public Udp(String s) {
      setDestPort(new Port(s.substring(0, 4)));
      setSrcPort(new Port(s.substring(4, 8)));
      this.packetLength = new PacketLength(s.substring(8, 12));
      this.checksum = new Checksum(s.substring(12, 16));
   }

   public PacketLength getPacketLength() {
      return packetLength;
   }

   public void setPacketLength(PacketLength packetLength) {
      this.packetLength = packetLength;
   }

   public Checksum getChecksum() {
      return checksum;
   }

   public void setChecksum(Checksum checksum) {
      this.checksum = checksum;
   }
}
