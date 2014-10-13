package project.protocol.datagram.layer3.arp;

public class ProtocolType {
   /*
    * Arp's unique part, default value is 0x0800
    * 16 bits
    */
   private String protocolType;

   public ProtocolType() {
      this.protocolType = "0800";
   }

   public String getProtocolType() {
      return protocolType;
   }

   public void setProtocolType(String protocolType) {
      this.protocolType = protocolType;
   }

   public String toString() {
      return this.protocolType;
   }

}
