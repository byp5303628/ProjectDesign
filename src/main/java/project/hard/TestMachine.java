package project.hard;

import project.hard.interf.InterfaceInfo;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.header.Packet;

/**
 * Created by ypbai on 2015/3/6.
 */
public class TestMachine {
   private TestInterfaceInfo interfaceInfo;
   private boolean connected = false;

   public InterfaceInfo getInteface() {
      return this.interfaceInfo;
   }

   public TestMachine() {
      this.interfaceInfo = new TestInterfaceInfo();
   }

   public void connectInterface(InterfaceInfo inter) {
      connected = true;
      interfaceInfo.setLinkedTo(inter);
      inter.setLinkedTo(interfaceInfo);
   }

   public void unConnect() {
      connected = false;
      interfaceInfo.getLinkedTo().setLinkedTo(null);
      interfaceInfo.setLinkedTo(null);
   }

   public void sendPacket(Packet packet) {
      interfaceInfo.handleOut(packet);
   }

   public boolean receivePacket() {
      return interfaceInfo.receivedPacket;
   }

   public Packet getReceivedPacket() {
      return interfaceInfo.getReceiveDetail();
   }

   public void reset() {
      this.interfaceInfo.reset();
   }

   public boolean isConnected() {
      return connected;
   }

   private class TestInterfaceInfo extends InterfaceInfo {
      private boolean receivedPacket = false;
      private Packet packet = null;

      public TestInterfaceInfo() {
         super();
         this.setMode(Mode.Route);
         this.setMacAddress(MacAddress.makeMacAddress());
      }

      @Override
      public void handleIn(Packet packet) {
         receivedPacket = true;
         this.packet = packet;
      }

      public void reset() {
         this.receivedPacket = false;
         this.packet = null;
      }

      public Packet getReceiveDetail() {
         return this.packet;
      }
   }
}
