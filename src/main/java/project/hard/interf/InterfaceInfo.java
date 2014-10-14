package project.hard.interf;

import project.protocol.datagram.layer2.ethernet.MacAddress;

public class InterfaceInfo {
   static public enum Mode {
      Bridge, Route,
   }

   private MacAddress addr;
   private String name;
   private String description;
   private Mode mode;
   private InterfaceInfo linkedTo;
   private String status;

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
}
