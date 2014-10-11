package project.protocol.datagram.layer3;

public class TypeLength {
   private String typeLength;

   public TypeLength() {
      this.typeLength = "45";
   }

   public String getTypeLength() {
      return typeLength;
   }

   public void setTypeLength(String typeLength) {
      this.typeLength = typeLength;
   }

   public int getHeaderLength() {
      int first = Integer.parseInt(this.typeLength.substring(0, 1), 16);
      int second = Integer.parseInt(this.typeLength.substring(1, 2), 16);
      return first * second;
   }

   public String toString() {
      return this.typeLength;
   }
}
