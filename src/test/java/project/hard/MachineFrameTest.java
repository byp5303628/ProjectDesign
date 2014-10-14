package project.hard;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.BoardExistingException;
import project.exceptions.BoardNotExistingException;
import project.exceptions.SlotNotExistException;

public class MachineFrameTest {
   @Test
   public void testInsertValidBoard() throws BoardExistingException,
         SlotNotExistException {
      MachineFrame mf = new MachineFrame(10);
      Assert.assertEquals(mf.getSlotNumber(), 10);
      Board b = new InterfaceBoard();
      mf.insertBoard(0, b);
   }

   @Test(expectedExceptions = BoardExistingException.class)
   public void testInsertInvalidBoard2() throws BoardExistingException,
         SlotNotExistException {
      MachineFrame mf = new MachineFrame(10);
      Assert.assertEquals(mf.getSlotNumber(), 10);
      Board b = new InterfaceBoard();
      mf.insertBoard(0, b);
      mf.insertBoard(0, b);
   }
   
   @Test
   public void testGetValidBoard() throws BoardExistingException,
         SlotNotExistException {
      MachineFrame mf = new MachineFrame(10);
      Assert.assertEquals(mf.getSlotNumber(), 10);
      Board b = new InterfaceBoard();
      mf.insertBoard(0, b);
      b = mf.getBoard(0);
      Assert.assertEquals(b.getType(), "Interface Board");
   }

   @Test(expectedExceptions = SlotNotExistException.class)
   public void testGetInvalidBoard() throws SlotNotExistException {
      MachineFrame mf = new MachineFrame(10);
      mf.getBoard(10);
   }

   @Test
   public void testDeleteBoard() throws BoardExistingException,
         SlotNotExistException, BoardNotExistingException {
      MachineFrame mf = new MachineFrame(10);
      Assert.assertEquals(mf.getSlotNumber(), 10);
      Board b = new InterfaceBoard();
      mf.insertBoard(0, b);
      mf.deleteBoard(0);
      Assert.assertNull(mf.getBoard(0));
   }

   @Test(expectedExceptions = BoardNotExistingException.class)
   public void testDeleteInvalidBoard1() throws BoardExistingException,
         SlotNotExistException, BoardNotExistingException {
      MachineFrame mf = new MachineFrame(10);
      Assert.assertEquals(mf.getSlotNumber(), 10);
      Board b = new InterfaceBoard();
      mf.insertBoard(0, b);
      mf.deleteBoard(0);
      Assert.assertNull(mf.getBoard(0));
      mf.deleteBoard(0);
   }

   @Test(expectedExceptions = BoardNotExistingException.class)
   public void testDeleteInvalidBoard2() throws BoardNotExistingException,
         SlotNotExistException {
      MachineFrame mf = new MachineFrame(10);
      mf.deleteBoard(0);
   }
}
