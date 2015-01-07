package project.protocol.header.layer4;

/**
 * Created by ypbai on 2015/1/5.
 */
public enum LAYER_4_PROTOCOL {
   UDP("UDP"), TCP("TCP"), RAW_IP("RAW_IP");
   private String s;

   LAYER_4_PROTOCOL(String s) {
      this.s = s;
   }

   public String toString() {
      return this.s;
   }
}
