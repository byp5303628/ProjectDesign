package project.hard.interf;

import project.hard.board.InterfaceBoard;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.header.Packet;
import project.protocol.header.layer2.Ethernet;
import project.protocol.header.layer3.Arp;
import project.soft.handle.PacketHandler;

public class InterfaceInfo implements PacketHandler {
   /**
    * Handle input packet, forward it with other module or drop it.
    *
    * @param packet
    */
   @Override
   public void handleIn(Packet packet) {
      if (packet.isBroadcast()) {
         // First if it is a broadcast packet, check if it is a arp request
         if (packet.isArpRequest()) {
            // answer it with self's interface info
            sendArpResponse(packet);
         } else {
            // it's a invalid packet, drop it.
            return;
         }
      } else if (packet.getDestMac().equals(this.getAddr())) {
         // This is the destination, send response
         switch (packet.getLayer3()) {
         case ARP:
            // update the arp table and return.
            this.getBoard().getMachineFrame().updateArpTable(packet);
            return;
         case IP:
            // let the function table do the interactive.
            this.getBoard().getMachineFrame()
                  .forwardThroughSessionTable(packet);
            return;
         case INVALID_PROTOCOL:
            // drop invalid packet
            return;
         }
      } else {
         // This is not the destination, forward it through mac table
         getBoard().getMachineFrame().forwardThroughMacTable(packet);
      }
   }

   @Override
   public void handleOut(Packet packet) {

   }

   static public enum Mode {
      Bridge, Route
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

   private void sendArpResponse(Packet packet) {
      Packet p = new Packet();
      Ethernet e = Ethernet.makeArpEthernet();
      e.setSrcMac(addr);
      e.setDestMac(packet.getSrcMac());
      p.setL2(e);

      Arp arp = Arp.makeArpResponse();
      arp.setSendIp(((Arp) packet.getL3()).getRecvIp());
      arp.setRecvIp(((Arp) packet.getL3()).getSendIp());
      arp.setSendMac(addr);
      arp.setRecvMac(packet.getSrcMac());
      p.setL3(arp);
      linkedTo.handleIn(p);
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
