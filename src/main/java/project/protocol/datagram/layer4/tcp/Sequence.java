package project.protocol.datagram.layer4.tcp;

/**
 * Created by ypbai on 2015/1/5.
 */
public class Sequence {
   /*
    * In total 32 bits, which is tcp in sequence and out sequence.
    */
   private String sequence;

   public Sequence() {
      this("00000000");
   }

   public Sequence(String sequence) {
      this.sequence = sequence;
   }

   public String getSequence() {
      return sequence;
   }

   public void setSequence(String sequence) {
      this.sequence = sequence;
   }
}
