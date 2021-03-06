package project.hard.interf;

import project.exceptions.InvalidPointStringException;
import project.hard.board.InterfaceBoard;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.header.Packet;
import project.protocol.header.layer2.Ethernet;
import project.protocol.header.layer3.Arp;
import project.soft.handle.PacketHandler;
import project.soft.nat.NatConfig;
import project.soft.route.ROUTE_TYPE;
import project.soft.route.RouteItem;

public abstract class InterfaceInfo implements PacketHandler {

   private MacAddress macAddress;
   private String name;
   private String description;
   private Mode mode;
   private InterfaceInfo linkedTo;
   private InterfaceBoard board;
   private String status;
   private Ipv4Address ipv4Address;
   private NatConfig natConfig;

   static public enum Mode {
      Bridge, Route
   }

   /**
    * Used for user control, user could set it up and down to control its status
    */
   private String upDown;

   public Ipv4Address getIpv4Address() {
      return ipv4Address;
   }

   protected InterfaceInfo() {
      this.macAddress = MacAddress.makeMacAddress();
   }

   /**
    * Set the ipv4 address of this interface, at the same time update the
    * routing table for direct type routing item
    *
    * @param pointString
    *           , which is the point string like 192.168.1.1
    * @param mask
    *           , which is the mask of the ip address
    * @throws project.exceptions.InvalidPointStringException
    */
   public void setIpv4Address(String pointString, int mask)
         throws InvalidPointStringException {
      if (mode.equals(Mode.Bridge)) {
         return;
      }
      // create a direct route item
      RouteItem ri = new RouteItem();
      ri.setType(ROUTE_TYPE.DIRECT);
      ri.setMask(mask);

      ipv4Address = new Ipv4Address();
      ipv4Address.setPointString(pointString);

      ri.setTarget(ipv4Address);
      ri.setOutputInterface(this);
      board.getMachineFrame().getRouteTable().updateItem(ri);
   }

   public void setIpv4Address(Ipv4Address ipv4Address) {
      if (mode.equals(Mode.Bridge)) {
         return;
      }
      this.ipv4Address = ipv4Address;
   }


   @Override
   public void handleIn(Packet packet) {
   }

   @Override
   public void handleOut(Packet packet) {
      this.getLinkedTo().handleIn(packet);
   }



   /**
    * If this ip address is destination
    *
    * @param ip
    *           , which is the ip you want to check
    * @return
    */
   public boolean isIpEqual(Ipv4Address ip) {
      return this.ipv4Address.equals(ip);
   }

   protected void sendArpResponse(Packet packet) {
      Packet p = new Packet();
      Ethernet e = Ethernet.makeArpEthernet();
      e.setSrcMac(this.getMacAddress());
      e.setDestMac(packet.getSrcMac());
      p.setL2(e);

      Arp arp = Arp.makeArpResponse();
      arp.setSendIp(((Arp) packet.getL3()).getRecvIp());
      arp.setRecvIp(((Arp) packet.getL3()).getSendIp());
      arp.setSendMac(this.getMacAddress());
      arp.setRecvMac(packet.getSrcMac());
      p.setL3(arp);
      this.getLinkedTo().handleIn(p);
   }

   protected boolean isValidArpResponsePacket(Packet packet) {
      Arp arp = (Arp) packet.getL3();
      if (!arp.getSendMac().equals(this.getMacAddress())) {
         return false;
      }
      if (!arp.getRecvIp().equals(ipv4Address)) {
         return false;
      }
      if (!arp.getRecvMac().equals(MacAddress.makeBraodcastMacAddress())) {
         return false;
      }
      return true;
   }

   public MacAddress getMacAddress() {
      return macAddress;
   }

   public void setMacAddress(MacAddress macAddress) {
      this.macAddress = macAddress;
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

   public String getUpDown() {
      return upDown;
   }

   public void setUpDown(String upDown) {
      this.upDown = upDown;
   }

   public InterfaceBoard getBoard() {
      return board;
   }

   public void setBoard(InterfaceBoard board) {
      this.board = board;
   }
}
