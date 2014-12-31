package project.help;

import java.util.Random;

public class Helper {
   public static String randomHexString(int length) {
      String result = "";
      for (int i = 0; i < length; i++) {
         result += randomHexChar();
      }
      return result;
   }

   private static String randomHexChar() {
      Random rand = new Random();
      return Integer.toHexString(rand.nextInt(16));
   }
}
