package project.protocol.datagram.layer2.ethernet;

import project.help.Helper;

public class MacAddress {
   /*
    * The detailed information for the MacAddress, it's 48 bits
    */
   private String addr;

   public MacAddress() {
      this("000000000000");
   }

   public MacAddress(String addr) {
      this.addr = addr;
   }

   public static MacAddress makeBraodcastMacAddress() {
      MacAddress mac = new MacAddress();
      mac.setAddr("ffffffffffff");
      return mac;
   }

   /**
    * Generate a random mac address
    *
    * @return
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

   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      return addr.equals(((MacAddress) obj).getAddr());
   }
}
