package project.protocol.datagram.layer2.ethernet;

import project.exceptions.InvalidMacAddressException;
import project.help.Helper;

public class MacAddress {
   /*
    * The detailed information for the MacAddress, it's 48 bits 
    */
   private String addr;

   public MacAddress() {
      this.setAddr("000000000000");
   }

   /**
    * Generate a random mac address
    * 
    * @return
    * @throws InvalidMacAddressException
    */
   public static MacAddress makeMacAddress() {
      MacAddress m = new MacAddress();
      m.setAddr(Helper.randomHexString(12));
      return m;
   }

   public String toString() {
      return this.addr;
   }

   public String getAddr() {
      return addr;
   }

   public void setAddr(String addr) {
      this.addr = addr.toLowerCase();
   }

   public boolean isBroadcast() {
      return this.addr.equals("ffffffffffff");
   }

   public boolean equals(MacAddress obj) {
      return this.addr.equals(obj.getAddr());
   }
}
