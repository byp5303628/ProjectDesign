package project.client.board;

import project.exceptions.BoardExistingException;
import project.exceptions.BoardNotExistingException;
import project.exceptions.SlotNotExistException;
import project.hard.board.Board;

/**
 * Created by ypbai on 2015/1/4.
 */
public interface BoardControl {
   /**
    * Insert board to specified slot
    * 
    * @param board
    * @throws BoardExistingException
    */
   public void insertBoard(int slotNumber, Board board)
         throws BoardExistingException, SlotNotExistException;

   /**
    * Delete specified slot number board.
    * 
    * @param slotNumber
    * @throws BoardNotExistingException
    */
   public void deleteBoard(int slotNumber) throws BoardNotExistingException,
         SlotNotExistException;

   /**
    * Display detail information of each board.
    */
   public void displayBoards();
}
