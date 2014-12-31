package project.help;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HelperTest {
   @Test
   public void testRandomHexString() {
      String s = Helper.randomHexString(12);
      Assert.assertEquals(s.length(), 12);
   }
}
