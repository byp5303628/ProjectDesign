package project.hard;

import java.util.ArrayList;
import java.util.HashMap;

import project.exceptions.InterfaceNotExistException;
import project.hard.interf.InterfaceInfo;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.header.Packet;
import project.soft.route.RouteTable;

public class InterfaceBoard extends Board {
   // TODO add route table
   static private RouteTable routeTable = new RouteTable();
   /**
    * Need to add access from the interfaceInfo, such as insert, query, delete
    */
   static private HashMap<Ipv4Address, MacAddress> arpTable =
         new HashMap<Ipv4Address, MacAddress>();
   // TODO add mac forward table

   private ArrayList<InterfaceInfo> interfaceList;

   public InterfaceBoard() {
      this.setType("Interface Board");
   }

   /**
    * Insert mac address to Arp table, if it exists, refresh it. Make it static
    * to let interface info have access of it
    * 
    * @param mac
    *           , which is the mac address we want to insert
    * @param ip
    *           , which is the ip we want to insert
    */
   static public void insertMacToArp(Ipv4Address ip, MacAddress mac) {
      if (arpTable.containsKey(ip)) {
         arpTable.remove(ip);
      }
      arpTable.put(ip, mac);
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
      return arpTable.get(ip);
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

   public void displaySession() {
      return;
   }

   /**
    * Interface board handle packet routing use its routing table
    * 
    * @param packet
    */
   public void processLayer3(Packet packet) {
      // TODO Auto-generated method stub

   }

   /**
    * Interface board handle packet forwarding use its mac table
    * 
    * @param packet
    */
   public void processLayer2(Packet packet) {
      // TODO Auto-generated method stub

   }

}
