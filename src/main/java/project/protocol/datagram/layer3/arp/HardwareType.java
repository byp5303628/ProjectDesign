package project.protocol.datagram.layer3.arp;

public class HardwareType {
   /*
    * 16bits, it's arp's unique part
    * first part
    */
   private String hardwareType;

   public HardwareType(String hardwareType) {
      this.hardwareType = hardwareType;
   }

   public HardwareType() {
      this.hardwareType = "0001";
   }

   public String getHardwareType() {
      return hardwareType;
   }

   public void setHardwareType(String hardwareType) {
      this.hardwareType = hardwareType;
   }

   public String toString() {
      return this.hardwareType;
   }

}
