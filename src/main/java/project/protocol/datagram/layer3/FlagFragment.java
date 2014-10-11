package project.protocol.datagram.layer3;

public class FlagFragment {
   /*
    * Ipv4 header's 5th part, 16 bits
    * to help handle the fragment pieces
    */
   private String ff;

   public FlagFragment() {
      this.ff = "0000";
   }

   public String getFf() {
      return ff;
   }

   public void setFf(String ff) {
      this.ff = ff;
   }

   public String toString() {
      return this.ff;
   }
}
