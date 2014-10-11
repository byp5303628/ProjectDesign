package project.hard.interf;

import project.protocol.datagram.layer2.MacAddress;

public abstract class InterfaceInfo {
   static public enum Mode {
      Bridge, Route,
   }

   private MacAddress addr;
   private String description;
   private Mode mode;

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
}
