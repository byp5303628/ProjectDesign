package project.hard.board;

import project.hard.MachineFrame;

public class Board {
   /*
    * A base class for several kinds of boards.
    */
   private String type;
   private int slot;
   private MachineFrame machineFrame;

   public void displaySession() {
      return;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public int getSlot() {
      return slot;
   }

   public void setSlot(int slot) {
      this.slot = slot;
   }

   public MachineFrame getMachineFrame() {
      return machineFrame;
   }

   public void setMachineFrame(MachineFrame machineFrame) {
      this.machineFrame = machineFrame;
   }
}
