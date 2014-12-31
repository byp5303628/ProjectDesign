package project.protocol.datagram.layer3.arp;

public class ProtocolLength {
   /*
    * Arp's unique part, default value is 0x04
    * 8 bits
    */
   private String protocolLength;

   public ProtocolLength(String protocolLength) {
      this.protocolLength = protocolLength;
   }

   public ProtocolLength() {
      this.setProtocolLength("04");
   }

   public String getProtocolLength() {
      return protocolLength;
   }

   public void setProtocolLength(String protocolLength) {
      this.protocolLength = protocolLength;
   }

   public String toString() {
      return this.protocolLength;
   }
}
