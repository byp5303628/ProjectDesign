package project.hard.board;

import junit.framework.Assert;

import org.testng.annotations.Test;

/**
 * Created by ypbai on 2014/12/31.
 */
public class MasterBoardTest {
   @Test
   public void testConstructor() {
      FunctionBoard board = new FunctionBoard();
      Assert.assertTrue(board.getType().equals("Function Board"));
      board.displaySession();
   }
}
