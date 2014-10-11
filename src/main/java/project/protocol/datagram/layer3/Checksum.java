package project.protocol.datagram.layer3;

public class Checksum {
   /*
    * 
    */
   private String checksum;

   public Checksum() {
      this.checksum = "0000";
   }

   public String getChecksum() {
      return checksum;
   }

   public void setChecksum(String checksum) {
      this.checksum = checksum;
   }

   public String toString() {
      return this.checksum;
   }
}
