package project.hard;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.exceptions.*;
import project.hard.board.Board;
import project.hard.board.FunctionBoard;
import project.hard.board.InterfaceBoard;
import project.hard.interf.InterfaceInfo;
import project.hard.interf.RouteInterfaceInfo;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.header.Packet;
import project.protocol.header.PacketConstant;

public class MachineFrameTest {
   @Test
   public void testInsertValidBoard() throws BoardExistingException,
         SlotNotExistException {
      MachineFrame mf = new MachineFrame(10);
      Assert.assertEquals(mf.getSlotNumber(), 10);
      Board b = new InterfaceBoard();
      mf.insertBoard(0, b);
   }

   @Test(expectedExceptions = BoardExistingException.class)
   public void testInsertInvalidBoard2() throws BoardExistingException,
         SlotNotExistException {
      MachineFrame mf = new MachineFrame(10);
      Assert.assertEquals(mf.getSlotNumber(), 10);
      Board b = new InterfaceBoard();
      mf.insertBoard(0, b);
      mf.insertBoard(0, b);
   }

   @Test
   public void testGetValidBoard() throws BoardExistingException,
         SlotNotExistException {
      MachineFrame mf = new MachineFrame(10);
      Assert.assertEquals(mf.getSlotNumber(), 10);
      Board b = new InterfaceBoard();
      mf.insertBoard(0, b);
      b = mf.getBoard(0);
      Assert.assertEquals(b.getType(), "Interface Board");
   }

   @Test(expectedExceptions = SlotNotExistException.class)
   public void testGetInvalidBoard() throws SlotNotExistException {
      MachineFrame mf = new MachineFrame(10);
      mf.getBoard(10);
   }

   @Test
   public void testDeleteBoard() throws BoardExistingException,
         SlotNotExistException, BoardNotExistingException {
      MachineFrame mf = new MachineFrame(10);
      Assert.assertEquals(mf.getSlotNumber(), 10);
      Board b = new InterfaceBoard();
      mf.insertBoard(0, b);
      mf.deleteBoard(0);
      Assert.assertNull(mf.getBoard(0));
   }

   @Test(expectedExceptions = BoardNotExistingException.class)
   public void testDeleteInvalidBoard1() throws BoardExistingException,
         SlotNotExistException, BoardNotExistingException {
      MachineFrame mf = new MachineFrame(10);
      Assert.assertEquals(mf.getSlotNumber(), 10);
      Board b = new InterfaceBoard();
      mf.insertBoard(0, b);
      mf.deleteBoard(0);
      Assert.assertNull(mf.getBoard(0));
      mf.deleteBoard(0);
   }

   @Test(expectedExceptions = BoardNotExistingException.class)
   public void testDeleteInvalidBoard2() throws BoardNotExistingException,
         SlotNotExistException {
      MachineFrame mf = new MachineFrame(10);
      mf.deleteBoard(0);
   }

   @Test
   public void testForwardWithNoRoute() {
      MachineFrame mf = new MachineFrame();
      Board f1 = new FunctionBoard();
      Board f2 = new FunctionBoard();

      try {
         mf.insertBoard(5, f1);
         mf.insertBoard(3, f2);
      } catch (BoardExistingException e) {
         e.printStackTrace();
      } catch (SlotNotExistException e) {
         e.printStackTrace();
      }

      Packet p =
            Packet.makePacket(PacketConstant.ETHERNET_IP_PACKET
                  + PacketConstant.UDP_IP_PACKET+ PacketConstant.UDP_HEADER);

      mf.forwardThroughSessionTable(p);
   }

   @Test
   public void testForwardWithRoute() {
//      MachineFrame mf = new MachineFrame();
//      Board f1 = new FunctionBoard();
//      Board f2 = new FunctionBoard();
//      InterfaceBoard interfaceBoard = new InterfaceBoard();
//
//      InterfaceInfo start = new RouteInterfaceInfo();
//      InterfaceInfo end = new RouteInterfaceInfo();
//
//      try {
//         mf.insertBoard(5, f1);
//         mf.insertBoard(3, f2);
//         mf.insertBoard(2, interfaceBoard);
//      } catch (BoardExistingException e) {
//         e.printStackTrace();
//      } catch (SlotNotExistException e) {
//         e.printStackTrace();
//      }
//
//      InterfaceInfo in = null;
//      InterfaceInfo out = null;
//
//      try {
//         // get in and out interface
//         in = interfaceBoard.getInterface(2);
//         out = interfaceBoard.getInterface(5);
//      } catch (InterfaceNotExistException e) {
//         e.printStackTrace();
//      }
//
//      // connect the interface
//      in.setLinkedTo(start);
//      start.setLinkedTo(in);
//
//      out.setLinkedTo(end);
//      end.setLinkedTo(out);
//
//      Packet p =
//              Packet.makePacket(PacketConstant.ETHERNET_IP_PACKET
//                      + PacketConstant.UDP_IP_PACKET+ PacketConstant.UDP_HEADER);
//
//
//
//
//      mf.forwardThroughSessionTable(p);
   }

   @Test
   public void testBootMachine() {
      MachineFrame mf = new MachineFrame();
      mf.bootMachine();
      mf.shutDownMachine();
   }

   @Test
   public void testSessionBackUp() {
      MachineFrame mf = new MachineFrame(20);
      mf.sessionBackUp();
      mf.displayRouteTable();
      mf.displayBoards();
      mf.displaySessions();
   }

   @Test
   public void testUpdateRoutingTable() {
      MachineFrame mf = new MachineFrame();
      Ipv4Address ip = new Ipv4Address();

      int mask = 24;

      Ipv4Address nextIp = new Ipv4Address();
      try {
         nextIp.setPointString("2.2.2.2");
      } catch (InvalidPointStringException e) {
         e.printStackTrace();
      }

      mf.updateRouteTable(ip, mask, nextIp);

      mf.displayRouteTable();
   }
}
