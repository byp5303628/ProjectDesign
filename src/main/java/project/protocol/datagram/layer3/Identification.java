package project.protocol.datagram.layer3;

public class Identification {
   /*
    * Ipv4 header's 4th part, 16 bits
    * to help identify the specific packet
    */
   private String iden;

   public String getIden() {
      return iden;
   }

   public void setIden(String iden) {
      this.iden = iden;
   }

}
