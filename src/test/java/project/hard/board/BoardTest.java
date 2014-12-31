package project.hard.board;

import org.testng.annotations.Test;

/**
 * Created by ypbai on 2014/12/31.
 */
public class BoardTest {
   @Test
   public void testDisplaySession() {
      Board board = new Board();
      board.displaySession();
   }
}
