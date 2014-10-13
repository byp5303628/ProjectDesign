package project.protocol.datagram.layer3.arp;

public class ArpOption {
   /*
    * Arp's unique part 
    * 0x0001 is request
    * 0x0002 is response
    * 16 bits
    */

   private String arpOption;

   public void arpRequest() {
      this.arpOption = "0001";
   }

   public void arpResponse() {
      this.arpOption = "0002";
   }

   public boolean isArpRequest() {
      return this.arpOption == "0001";
   }

   public boolean isArpResponse() {
      return this.arpOption == "0002";
   }

   public String toString() {
      return this.arpOption;
   }
}
