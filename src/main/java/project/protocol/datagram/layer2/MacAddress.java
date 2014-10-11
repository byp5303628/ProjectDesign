package project.protocol.datagram.layer2;

import project.exceptions.InvalidMacAddressException;

public class MacAddress {
   /*
    * The detailed information for the MacAddress, it's 48 bits 
    */
   private final String INPUT_PATTERN = "[1234567890abcdefABCDEF]{12}";
   private String addr;

   public MacAddress() throws InvalidMacAddressException {
      this.setAddr("000000000000");
   }

   public String getAddr() {
      return addr;
   }

   public void setAddr(String addr) throws InvalidMacAddressException {
      if (!addr.matches(INPUT_PATTERN)) {
         System.out.println(addr.matches(INPUT_PATTERN));
      }
      this.addr = addr.toLowerCase();
   }

   public boolean isBroadcast() {
      return this.addr.equals("ffffffffffff");
   }

   public boolean equals(MacAddress obj) {
      return this.addr.equals(obj.getAddr());
   }
}
