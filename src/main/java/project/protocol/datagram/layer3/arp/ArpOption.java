package project.protocol.datagram.layer3.arp;


public class ArpOption {
   /*
    * Arp's unique part 
    * 0x0001 is request
    * 0x0002 is response
    * 16 bits
    */

   private String arpOption;

   public ArpOption(String arpOption) {
      this.arpOption = arpOption;
   }

   public ArpOption() {
   }

   public static ArpOption makeArpRequestOption() {
      ArpOption a = new ArpOption("0001");
      return a;
   }

   public static ArpOption makeArpResponseOption() {
      ArpOption a = new ArpOption("0002");
      return a;
   }

   public boolean isArpRequest() {
      return this.arpOption.equals("0001");
   }

   public boolean isArpResponse() {
      return this.arpOption.equals("0002");
   }

   public String toString() {
      return this.arpOption;
   }
}
