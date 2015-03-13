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
      return true;
   }

   public boolean isConnected() {
      return connected;
   }

   public class TestInterfaceInfo extends InterfaceInfo {
      private boolean receivedPacket = false;

      public TestInterfaceInfo() {
         this.setMode(Mode.Route);
         this.setMacAddress(MacAddress.makeMacAddress());
      }

      @Override
      public void handleIn(Packet packet) {
         receivedPacket = true;
      }

      public void reset() {
         this.receivedPacket = false;
      }
   }
}
