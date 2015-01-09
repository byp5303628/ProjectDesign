package project.protocol.datagram.layer3.ip;

public class Checksum {
   /*
    * 
    */
   private String checksum;

   public Checksum(String checksum) {
      this.checksum = checksum;
   }

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

   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (!(obj instanceof Checksum)) {
         return false;
      }
      return checksum.equals(((Checksum) obj).getChecksum());
   }

   @Override
   public int hashCode() {
      return checksum.hashCode();
   }
}
