package project.protocol.datagram.layer3.ip;

public class Identification {
   /*
    * Ipv4 header's 4th part, 16 bits
    * to help identify the specific packet
    */
   private String iden;

   public Identification() {
      this.iden = "0000";
   }

   public String getIden() {
      return iden;
   }

   public void setIden(String iden) {
      this.iden = iden;
   }

   public String toString() {
      return this.iden;
   }
}
