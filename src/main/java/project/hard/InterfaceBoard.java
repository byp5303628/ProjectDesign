package project.hard;

import java.util.ArrayList;

import project.exceptions.InterfaceNotExistException;
import project.hard.interf.InterfaceInfo;

public class InterfaceBoard extends Board {
   // TODO add route table
   // TODO add arp table
   // TODO add mac forward table

   private ArrayList<InterfaceInfo> interfaceList;

   public InterfaceBoard() {
      this.setType("Interface Board");
   }

   /**
    * Constructor of the InterfaceBoard, init the number of interface on this
    * board.
    * 
    * @param size
    */
   public InterfaceBoard(int size) {
      this.interfaceList = new ArrayList<InterfaceInfo>();
      for (int i = 0; i < size; i++) {
         InterfaceInfo inter = new InterfaceInfo();
         String name = "G" + this.getSlot() + "/0/" + i;
         inter.setName(name);
         this.interfaceList.add(inter);
      }
      this.setType("Interface Board");
   }

   /**
    * Get interface info object through index
    * 
    * @param index
    *           , which is the index number of the interfaceInfo
    * @return
    * @throws InterfaceNotExistException
    */
   public InterfaceInfo getInterface(int index)
         throws InterfaceNotExistException {
      if (0 <= index && index < this.interfaceList.size())
         return this.interfaceList.get(index);
      else
         throw new InterfaceNotExistException(index);
   }

   public void displaySession() {
      return;
   }

}
