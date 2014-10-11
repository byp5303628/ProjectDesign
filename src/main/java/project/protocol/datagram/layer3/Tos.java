package project.protocol.datagram.layer3;

public class Tos {
   /*
    * Ipv4 header's second part.
    * It's short for type of service
    * also recognized as a dscp priority, 8bits
    */
   private String tos;

   public String getTos() {
      return tos;
   }

   public void setTos(String tos) {
      this.tos = tos;
   }
   
}
