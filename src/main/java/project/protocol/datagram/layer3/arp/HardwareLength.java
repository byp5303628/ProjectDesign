package project.protocol.datagram.layer3.arp;

public class HardwareLength {
   /*
    * Arp's unique part, default value is 0x06
    * 8 bits
    */
   private String hardwareLength;

   public HardwareLength() {
      this.hardwareLength = "06";
   }

   public int getHardwareLength() {
      return Integer.parseInt(this.hardwareLength, 16) * 8;
   }

   public void setHardwareLength(String hardwareLength) {
      this.hardwareLength = hardwareLength;
   }

   public String toString() {
      return this.hardwareLength;
   }

}
