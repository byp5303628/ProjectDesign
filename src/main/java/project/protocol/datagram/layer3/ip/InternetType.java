package project.protocol.datagram.layer3.ip;

public class InternetType {
   /*
    * 8 bits, TCP or UDP or SCCP
    */
   private String interType;

   public InternetType(String interType) {
      this.interType = interType;
   }

   public InternetType() {
      this.interType = "01";
   }

   public String getInterType() {
      return interType;
   }

   public void setInterType(String interType) {
      this.interType = interType;
   }

   public String toString() {
      return this.interType;
   }
}
