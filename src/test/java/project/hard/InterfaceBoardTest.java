package project.hard;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.InterfaceNotExistException;
import project.hard.board.Board;
import project.hard.board.InterfaceBoard;
import project.hard.interf.InterfaceInfo;

public class InterfaceBoardTest {
   @Test
   public void testConstructor() throws InterfaceNotExistException {
      Board b = new InterfaceBoard(10);
      for (int i = 0; i < 10; i++) {
         InterfaceInfo inter = ((InterfaceBoard) b).getInterface(i);
         Assert.assertTrue(inter.getName().matches("G[0-9]/0/[0-9]"));
      }
   }

   @Test(expectedExceptions = InterfaceNotExistException.class)
   public void testGetInterface() throws InterfaceNotExistException {
      Board b = new InterfaceBoard(10);
      ((InterfaceBoard) b).getInterface(11);
   }
}
