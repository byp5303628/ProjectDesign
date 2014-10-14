package project.hard;

import java.util.ArrayList;

import project.hard.interf.InterfaceInfo;

public class InterfaceBoard extends Board {
   // TODO add route table
   // TODO add arp table
   // TODO add mac forward table
   
   private ArrayList<InterfaceInfo> interfaceList;
   
   public InterfaceBoard(){
      this.interfaceList = new ArrayList<InterfaceInfo>();
      this.setType("Interface Board");
   }

   public void displaySession() {
      // TODO Auto-generated method stub

   }

}
