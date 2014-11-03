package project.hard.interf;

import project.hard.InterfaceBoard;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.header.Packet;

public class InterfaceInfo {
   static public enum Mode {
      Bridge, Route,
   }

   private MacAddress addr;
   private String name;
   private String description;
   private Mode mode;
   private InterfaceInfo linkedTo;
   private InterfaceBoard board;
   private String status;
   /**
    * Used for user control, user could set it up and down to control its status
    */
   private String updown;

   /**
    * Process packet
    */
   public void processPacket(Packet packet) {

   }

   public void processLayer2(Packet packet, MacAddress mac) {
      if (packet.getDestMac().isBroadcast()) {
         // First if it is a broadcast packet
         if (packet.getLayer3().equals("ARP")) {
            this.sendArpResponse();
         } else {
            this.forwardPacket(packet);
         }
      } else if (packet.getDestMac().equals(mac)) {
         // process Layer 3
         this.board.processLayer3(packet);
      } else {
         // forward it use Mac table
         this.board.processLayer2(packet);
      }
   }

   private void forwardPacket(Packet packet) {
      // TODO Auto-generated method stub

   }

   private void sendArpResponse() {
      // TODO Auto-generated method stub

   }

   public MacAddress getAddr() {
      return addr;
   }

   public void setAddr(MacAddress addr) {
      this.addr = addr;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Mode getMode() {
      return mode;
   }

   public void setMode(Mode mode) {
      this.mode = mode;
   }

   public InterfaceInfo getLinkedTo() {
      return linkedTo;
   }

   public void setLinkedTo(InterfaceInfo linkedTo) {
      this.linkedTo = linkedTo;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getUpdown() {
      return updown;
   }

   public void setUpdown(String updown) {
      this.updown = updown;
   }

   public InterfaceBoard getBoard() {
      return board;
   }

   public void setBoard(InterfaceBoard board) {
      this.board = board;
   }
}
