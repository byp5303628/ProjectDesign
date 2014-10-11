package project.hard;

import java.util.ArrayList;

import project.exceptions.BoardExistingException;
import project.exceptions.BoardNotExistingException;

public class MachineFrame {
   /*
    * The boards can hang on the Machine Frame. Each Machine Frame have several
    * slots, for this one, have 10 slots. Each slot can get MasterBoard or
    * FunctionBoard or InterfaceBoard
    */
   private int slotNumber;
   private String description;
   private ArrayList<Board> boardList;

   public MachineFrame(int slotNumber) {
      this.slotNumber = slotNumber;
      this.boardList = new ArrayList<Board>();
      for (int i = 0; i < slotNumber; i++) {
         this.boardList.add(new Board());
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
    */
   public void insertBoard(int slotNum, Board board)
         throws BoardExistingException {
      if (this.boardList.get(slotNum).getType() == null) {
         this.boardList.add(slotNum, board);
      } else {
         throw new BoardExistingException(slotNum);
      }
   }

   /**
    * Remove the specific slot number's board
    * 
    * @param slotNum
    *           , which is the specific slot number we want to insert
    * @throws BoardNotExistingException
    */
   public void deleteBoard(int slotNum) throws BoardNotExistingException {
      if (this.boardList.get(slotNum).getType() == null) {
         throw new BoardNotExistingException(slotNum);
      }
      this.boardList.add(slotNum, new Board());
   }

   /**
    * Display the session of the machine frame
    */
   public void displaySessions() {
      for (Board board : this.boardList) {
         board.displaySession();
      }
   }

   public String getDescription() {
      return description;
   }

   public int getSlotNumber() {
      return this.slotNumber;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public void processPacket() {

   }
}
