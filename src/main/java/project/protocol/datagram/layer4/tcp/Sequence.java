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

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Sequence)) return false;

      Sequence sequence1 = (Sequence) o;

      if (!sequence.equals(sequence1.sequence)) return false;

      return true;
   }

   @Override
   public int hashCode() {
      return sequence.hashCode();
   }

   public void setSequence(String sequence) {
      this.sequence = sequence;
   }
}
