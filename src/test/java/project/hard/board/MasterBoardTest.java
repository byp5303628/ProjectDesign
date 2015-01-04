package project.hard.board;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ypbai on 2014/12/31.
 */
public class MasterBoardTest {
   @Test
   public void testConstructor() {
      MasterBoard board = new MasterBoard();
      Assert.assertTrue(board.getType().equals("Master Board"));
      board.displaySession();
   }

}
