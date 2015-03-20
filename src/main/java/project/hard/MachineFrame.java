package project.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import project.client.MachineControl;
import project.exceptions.BoardExistingException;
import project.exceptions.BoardNotExistingException;
import project.exceptions.SlotNotExistException;
import project.hard.board.Board;
import project.hard.board.FunctionBoard;
import project.hard.interf.InterfaceInfo;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.header.Packet;
import project.soft.aspf.Aspf;
import project.soft.mac.MacTable;
import project.soft.route.RouteTable;
import project.soft.session.SessionItem;
import project.soft.session.SessionTable;

public class MachineFrame implements MachineControl {
   /*
    * The boards can hang on the Machine Frame. Each Machine Frame have several
    * slots, for this one, have 10 slots. Each slot can get MasterBoard or
    * FunctionBoard or InterfaceBoard
    */
   private int slotNumber;
   private ArrayList<Board> boardList;
   private Aspf aspf;
   /*
    * This map is used to map int to slot number. So that, when machine frame
    * must handle a packet, it can easily get the assigned session table.
    */
   private Map<Integer, Integer> mapToSlot = new HashMap<Integer, Integer>();

   /**
    * Need to add access from the interfaceInfo, such as insert, query, delete
    * One Machine Frame has only one routeTable
    */
   private RouteTable routeTable;
   private MacTable macTable;

   public MachineFrame() {
      this(10);
   }

   public MachineFrame(int slotNumber) {
      this.slotNumber = slotNumber;
      this.boardList = new ArrayList<Board>();
      for (int i = 0; i < slotNumber; i++) {
         this.boardList.add(null);
      }
      this.routeTable = new RouteTable();
      this.macTable = new MacTable();
      this.aspf = new Aspf();
   }

   /**
    * Handle the packet through function board.
    *
    * @param packet
    */
   public void forwardThroughSessionTable(Packet packet) {
      // (TODO : create hash set to handle the packet through function board.)
      // find session table
      SessionTable targetSessionTable = findSessionTable(packet);

      // find session item
      SessionItem si = targetSessionTable.match(packet);

      // if there is no matching session item in the session table
      if (si == null) {
         si = SessionItem.createSessionItem(packet);
      }

      // check if aspf allow this packet
      if (aspf.isPacketAllowed(si, packet)) {
         forwardThroughRouteTable(packet);
         targetSessionTable.insertItem(si);
      } else {
         targetSessionTable.deleteItem(si);
      }
   }


   private SessionTable findSessionTable(Packet packet) {
      // finde a packet through hash
      int hash = packet.hashFromSourceAndDest() % mapToSlot.size();
      return ((FunctionBoard) boardList.get(mapToSlot.get(hash)))
            .getSessionTable();
   }

   /**
    * Forward the packet through routing table, but first check it with session
    * table check.
    *
    * @param packet
    */
   private void forwardThroughRouteTable(Packet packet) {
      //      forwardThroughSessionTable(packet);
      routeTable.forward(packet);
   }

   /**
    * Forward the packet through mac table.
    *
    * @param packet
    */
   public void forwardThroughMacTable(Packet packet) {
      macTable.forward(packet);
   }

   /**
    * Update Arp table throgh packet.
    *
    * @param packet
    */
   public void updateArpTable(Packet packet) {
      routeTable.updateArpTable(packet);
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
   @Override
   public void insertBoard(int slotNum, Board board)
         throws BoardExistingException, SlotNotExistException {
      if (this.getBoard(slotNum) == null) {
         this.boardList.add(slotNum, board);
         if (board.getType().equals("Function Board")) {
            mapToSlot.put(mapToSlot.size(), slotNum);
         }

         board.setSlot(slotNum);
         board.setMachineFrame(this);
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

   @Override
   public void displayBoards() {
      System.out.println("Boards Info");
      for (int i = 0; i < this.slotNumber; i++) {
         if (boardList.get(i) != null) {
            System.out.println("Slot " + i + ":");
            System.out.println(this.boardList.get(i).toString());
         }
      }
   }

   /**
    * Display the session of the machine frame
    */
   public void displaySessions() {
      System.out.println("Session Info");
      for (int i = 0; i < this.slotNumber; i++) {
         System.out.println("Slot " + i + ":");
         Board b = boardList.get(i);
         if (b != null) {
            b.displaySession();
         }
      }
   }

   public int getSlotNumber() {
      return this.slotNumber;
   }

   @Override
   public void updateRouteTable(Ipv4Address target, int mask,
         Ipv4Address nextHop) {

   }

   public void displayRouteTable() {
      routeTable.display();
   }

   public RouteTable getRouteTable() {
      return routeTable;
   }

   @Override
   public void bootMachine() {

   }

   @Override
   public void shutDownMachine() {

   }

   @Override
   public void sessionBackUp() {

   }

   @Override
   public void setIpv4Address(String pointString, int mask) {

   }

   @Override
   public void shutDown(InterfaceInfo interfaceInfo) {

   }

   @Override
   public void startUp(InterfaceInfo interfaceInfo) {

   }
}
