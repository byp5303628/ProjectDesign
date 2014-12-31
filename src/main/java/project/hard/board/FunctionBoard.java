package project.hard.board;

import project.soft.session.SessionTable;

public class FunctionBoard extends Board {

   private SessionTable sessionTable;

   public FunctionBoard() {
      sessionTable = new SessionTable();

   }

   @Override
   public void displaySession() {
      // TODO Auto-generated method stub
      sessionTable.display();
   }
}
