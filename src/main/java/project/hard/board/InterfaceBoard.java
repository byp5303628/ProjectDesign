package project.hard.board;

import java.util.ArrayList;

import project.exceptions.InterfaceNotExistException;
import project.hard.interf.InterfaceInfo;
import project.hard.interf.RouteInterfaceInfo;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.header.Packet;
import project.soft.handle.PacketHandler;

public class InterfaceBoard extends Board implements PacketHandler {
   private ArrayList<InterfaceInfo> interfaceList;

   public InterfaceBoard() {
      // by default, give interface board 10 interfaces.
      this(10);
   }

   /**
    * Query the mac address of a specific ip address, if it exists, return mac
    * address, else, return null
    *
    * @param ip
    *           , which is the ip we want to insert
    * @return mac address
    */
   static public MacAddress getMacFromArp(Ipv4Address ip) {
      return null;
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
         InterfaceInfo inter = new RouteInterfaceInfo();
         String name = "G" + this.getSlot() + "/0/" + i;
         inter.setName(name);
         inter.setBoard(this);
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

   @Override
   public void handleIn(Packet packet) {
      // (TODO: Ethan)
   }

   @Override
   public void handleOut(Packet packet) {
      // (TODO: Ethan)
   }
}
