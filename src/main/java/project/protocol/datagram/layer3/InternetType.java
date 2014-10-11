package project.protocol.datagram.layer3;

public class InternetType {
   private String interType;

   public InternetType() {
      this.interType = "0001";
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
