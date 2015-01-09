package project.help;

import java.util.Random;

public class Helper {
   public static String randomHexString(int length) {
      StringBuffer result = new StringBuffer("");
      for (int i = 0; i < length; i++) {
         result.append(randomHexChar());
      }
      return result.toString();
   }

   private static String randomHexChar() {
      Random rand = new Random();
      return Integer.toHexString(rand.nextInt(16));
   }
}
