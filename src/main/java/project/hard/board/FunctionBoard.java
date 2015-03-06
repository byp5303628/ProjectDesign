package project.hard.board;

import project.soft.session.SessionTable;

public class FunctionBoard extends Board {

   private SessionTable sessionTable;

   public FunctionBoard() {
      sessionTable = new SessionTable();
      this.setType("Function Board");
   }

   @Override
   public void displaySession() {
      // TODO Auto-generated method stub
      sessionTable.display();
   }

   public SessionTable getSessionTable() {
      return sessionTable;
   }
}
