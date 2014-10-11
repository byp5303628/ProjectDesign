package project.exceptions;

public class InvalidFrameType extends Exception {

   public InvalidFrameType(String frameType) {
      System.out.println("FrameType: \"" + frameType + "\"is not valid!");
   }

   /**
    * 
    */
   private static final long serialVersionUID = -3291512671066107233L;


}
