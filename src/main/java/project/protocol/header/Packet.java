package project.protocol.header;

import project.protocol.header.layer2.Layer2;
import project.protocol.header.layer3.Layer3;
import project.protocol.header.layer4.Layer4;

public class Packet {
   private Layer2 l2;
   private Layer3 l3;
   private Layer4 l4;

   public Layer3 getL3() {
      return l3;
   }

   public void setL3(Layer3 l3) {
      this.l3 = l3;
   }

   public Layer2 getL2() {
      return l2;
   }

   public void setL2(Layer2 l2) {
      this.l2 = l2;
   }

   public Layer4 getL4() {
      return l4;
   }

   public void setL4(Layer4 l4) {
      this.l4 = l4;
   }

   public void processPacket() {
      processLayer2();
      processLayer3();
      processLayer4();
   }

   private void processLayer4() {
      // TODO Auto-generated method stub

   }

   private void processLayer3() {
      // TODO Auto-generated method stub

   }

   private void processLayer2() {
      // TODO Auto-generated method stub

   }
}
