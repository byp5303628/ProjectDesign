package project.protocol.datagram.layer3.ip;

import project.protocol.header.layer4.LAYER_4_PROTOCOL;

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

   public LAYER_4_PROTOCOL getNextProtocol() {
      int temp = getProtocolNum();
      if (temp == 17) {
         return LAYER_4_PROTOCOL.UDP;
      } else if (temp == 6) {
         return LAYER_4_PROTOCOL.TCP;
      } else {
         return LAYER_4_PROTOCOL.RAW_IP;
      }
   }

   private int getProtocolNum() {
      return Integer.parseInt(interType, 16);
   }

   public void setInterType(String interType) {
      this.interType = interType;
   }

   public String toString() {
      return this.interType;
   }
}
