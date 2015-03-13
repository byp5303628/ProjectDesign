package project.hard;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.hard.interf.InterfaceInfo;
import project.hard.interf.RouteInterfaceInfo;

/**
 * Created by ypbai on 2015/3/6.
 */
public class TestTestMachine {
   @Test
   public void testBasic() {
      TestMachine tm = new TestMachine();
      InterfaceInfo in = new RouteInterfaceInfo();

      tm.connectInterface(in);

      Assert.assertTrue(tm.isConnected());
      tm.unConnect();
      Assert.assertFalse(tm.isConnected());
   }
}
