package project.protocol.datagram.layer3.ip;

public class FlagFragment {
   /*
    * Ipv4 header's 5th part, 16 bits
    * to help handleIn the fragment pieces
    */
   private String ff;

   public FlagFragment(String ff) {
      this.ff = ff;
   }

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
