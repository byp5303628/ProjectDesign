package project.protocol.datagram.layer4.tcp;

/**
 * Created by ypbai on 2015/1/6.
 */
public class TcpInteractive {
   private String offset;
   private String other;
   private final static int SYN = 0x2;
   private final static int FIN = 0x1;
   private final static int ACK = 0x10;
   private final static int RST = 0x8;

   public TcpInteractive() {
      this.offset = "0";
      this.other = "000";
   }

   public TcpInteractive(String s) {
      this.offset = s.substring(0, 1);
      this.other = s.substring(1, 4);
   }

   public String getOffset() {
      return offset;
   }

   public void setOffset(String offset) {
      this.offset = offset;
   }

   public boolean isSyn() {
      int otherNum = getOther();
      if ((otherNum & SYN) == SYN) {
         return true;
      }
      return false;
   }

   public boolean isAck() {
      int otherNum = getOther();
      if ((otherNum & ACK) == ACK) {
         return true;
      }
      return false;
   }

   public boolean isRst() {
      int otherNum = getOther();
      if ((otherNum & RST) == RST) {
         return true;
      }
      return false;
   }

   public boolean isFin() {
      int otherNum = getOther();
      if ((otherNum & FIN) == FIN) {
         return true;
      }
      return false;
   }

   public void setSyn() {
      int num = getOther() | SYN;
      String s = Integer.toHexString(num);
      setOther(s);
   }

   public void setFin() {
      int num = getOther() | FIN;
      String s = Integer.toHexString(num);
      setOther(s);
   }

   public void setAck() {
      int num = getOther() | ACK;
      String s = Integer.toHexString(num);
      setOther(s);
   }

   public void setRst() {
      int num = getOther() | RST;
      String s = Integer.toHexString(num);
      setOther(s);
   }

   private int getOther() {
      return Integer.parseInt(other, 16);
   }

   private void setOther(String s) {
      while (s.length() < 3) {
         s = "0" + s;
      }
      other = s;
   }
}
