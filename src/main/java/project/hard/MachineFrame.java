package project.hard;

import java.util.ArrayList;

import project.exceptions.BoardExistingException;
import project.exceptions.BoardNotExistingException;
import project.exceptions.SlotNotExistException;

public class MachineFrame {
   /*
    * The boards can hang on the Machine Frame. Each Machine Frame have several
    * slots, for this one, have 10 slots. Each slot can get MasterBoard or
    * FunctionBoard or InterfaceBoard
    */
   private int slotNumber;
   private ArrayList<Board> boardList;

   public MachineFrame(int slotNumber) {
      this.slotNumber = slotNumber;
      this.boardList = new ArrayList<Board>();
      for (int i = 0; i < slotNumber; i++) {
         this.boardList.add(null);
      }
   }

   /**
    * Insert a board to a specific slot
    * 
    * @param slotNum
    *           , which is the specific slot number we want to insert
    * @param board
    *           , which is the board
    * @throws BoardExistingException
    * @throws SlotNotExistException
    */
   public void insertBoard(int slotNum, Board board)
         throws BoardExistingException, SlotNotExistException {
      if (this.getBoard(slotNum) == null) {
         this.boardList.add(slotNum, board);
         board.setSlot(slotNum);
      } else {
         throw new BoardExistingException(slotNum);
      }
   }

   /**
    * Query the specific slot number's board, if not exist, return null
    * 
    * @param slotNum
    *           , which is the specific slot number we want to query
    * @return
    * @throws SlotNotExistException
    */
   public Board getBoard(int slotNum) throws SlotNotExistException {
      if (0 <= slotNum && slotNum < this.slotNumber)
         return this.boardList.get(slotNum);
      else {
         throw new SlotNotExistException(slotNum);
      }
   }

   /**
    * Remove the specific slot number's board
    * 
    * @param slotNum
    *           , which is the specific slot number we want to insert
    * @throws BoardNotExistingException
    * @throws SlotNotExistException
    */
   public void deleteBoard(int slotNum) throws BoardNotExistingException,
         SlotNotExistException {
      if (this.getBoard(slotNum) == null) {
         throw new BoardNotExistingException(slotNum);
      }
      this.boardList.add(slotNum, null);
   }

   /**
    * Display the session of the machine frame
    */
   public void displaySessions() {
      for (int i = 0; i < this.slotNumber; i++) {
         System.out.println("Slot " + i + ":");
         this.boardList.get(i).displaySession();
      }
   }

   public int getSlotNumber() {
      return this.slotNumber;
   }

   public void processPacket() {

   }
}
