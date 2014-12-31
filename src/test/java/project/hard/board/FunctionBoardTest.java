package project.hard.board;

import org.testng.annotations.Test;

/**
 * Created by ypbai on 2014/12/26.
 */
public class FunctionBoardTest {
   @Test
   public void testConstructor() {
      FunctionBoard fb = new FunctionBoard();
      fb.displaySession();
   }
}
