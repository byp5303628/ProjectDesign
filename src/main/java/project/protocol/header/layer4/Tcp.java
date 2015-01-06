package project.protocol.header.layer4;

import project.protocol.datagram.layer3.ip.Checksum;
import project.protocol.datagram.layer4.Port;
import project.protocol.datagram.layer4.tcp.Sequence;
import project.protocol.datagram.layer4.tcp.TcpInteractive;
import project.protocol.datagram.layer4.tcp.UrgentPoint;
import project.protocol.datagram.layer4.tcp.Window;

/**
 * Created by ypbai on 2015/1/5.
 */
public class Tcp extends PortLayer {
   private Sequence start;
   private Sequence end;
   private TcpInteractive interactive;
   private Window window;
   private Checksum checksum;
   private UrgentPoint urgentPoint;

   public Tcp() {
      setDestPort(new Port());
      setSrcPort(new Port());
      start = new Sequence();
      end = new Sequence();
      interactive = new TcpInteractive();
      window = new Window();
      checksum = new Checksum();
      urgentPoint = new UrgentPoint();
   }

   /**
    * Construct a TCP header through hex string.
    * 
    * @param s
    */
   public Tcp(String s) {
      setDestPort(new Port(s.substring(0, 4)));
      setSrcPort(new Port(s.substring(4, 8)));
      start = new Sequence(s.substring(8, 16));
      end = new Sequence(s.substring(16, 24));
      interactive = new TcpInteractive(s.substring(24, 28));
      window = new Window(s.substring(28, 32));
      checksum = new Checksum(s.substring(32, 36));
      urgentPoint = new UrgentPoint(s.substring(36, 40));
   }

   public void setSynPacket() {
      interactive.setSyn();
   }

   public void setFinPacket() {
      interactive.setFin();
   }

   public void setAckPacket() {
      interactive.setAck();
   }

   public void setRstPacket() {
      interactive.setRst();
   }

   public boolean isSynPacket() {
      return interactive.isSyn();
   }

   public boolean isAckPacket() {
      return interactive.isAck();
   }

   public boolean isFinPacket() {
      return interactive.isFin();
   }

   public boolean isRstPacket() {
      return interactive.isRst();
   }

   public Sequence getStart() {
      return start;
   }

   public void setStart(Sequence start) {
      this.start = start;
   }

   public Sequence getEnd() {
      return end;
   }

   public void setEnd(Sequence end) {
      this.end = end;
   }

   public Window getWindow() {
      return window;
   }

   public void setWindow(Window window) {
      this.window = window;
   }

   public Checksum getChecksum() {
      return checksum;
   }

   public void setChecksum(Checksum checksum) {
      this.checksum = checksum;
   }

   public UrgentPoint getUrgentPoint() {
      return urgentPoint;
   }

   public void setUrgentPoint(UrgentPoint urgentPoint) {
      this.urgentPoint = urgentPoint;
   }
}
