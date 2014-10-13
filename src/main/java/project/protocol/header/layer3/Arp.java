package project.protocol.header.layer3;

import project.exceptions.InvalidMacAddressException;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.arp.ArpOption;
import project.protocol.datagram.layer3.arp.HardwareLength;
import project.protocol.datagram.layer3.arp.HardwareType;
import project.protocol.datagram.layer3.arp.ProtocolLength;
import project.protocol.datagram.layer3.arp.ProtocolType;
import project.protocol.datagram.layer3.ip.Ipv4Address;

public class Arp extends Layer3 {
   private HardwareType hardwareType;
   private ProtocolType protocolType;
   private HardwareLength hardwareLength;
   private ProtocolLength protocolLength;
   private ArpOption arpOption;
   private MacAddress sendMac;
   private Ipv4Address sendIp;
   private MacAddress recvMac;
   private Ipv4Address recvIp;

   public Arp() throws InvalidMacAddressException {
      this.hardwareLength = new HardwareLength();
      this.hardwareType = new HardwareType();
      this.protocolLength = new ProtocolLength();
      this.protocolType = new ProtocolType();
      this.arpOption = new ArpOption();
      this.sendIp = new Ipv4Address();
      this.sendMac = new MacAddress();
      this.recvIp = new Ipv4Address();
      this.recvMac = new MacAddress();
   }

   public boolean isRequest() {
      return this.getArpOption().isArpRequest();
   }

   public boolean isResponse() {
      return this.getArpOption().isArpResponse();
   }

   public static Arp makeArpRequest() throws InvalidMacAddressException {
      Arp arp = new Arp();
      ArpOption ao = new ArpOption();
      ao.arpRequest();
      MacAddress broadcast = new MacAddress();
      broadcast.setAddr("ffffffffffff");
      arp.setArpOption(ao);
      arp.setSendMac(broadcast);
      return arp;
   }

   public static Arp makeArpResponse() throws InvalidMacAddressException {
      Arp arp = new Arp();
      ArpOption ao = new ArpOption();
      ao.arpResponse();
      arp.setArpOption(ao);
      return arp;
   }

   /**
    * @return the hardwareType
    */
   public HardwareType getHardwareType() {
      return hardwareType;
   }

   /**
    * @param hardwareType
    *           the hardwareType to set
    */
   public void setHardwareType(HardwareType hardwareType) {
      this.hardwareType = hardwareType;
   }

   /**
    * @return the protocolType
    */
   public ProtocolType getProtocolType() {
      return protocolType;
   }

   /**
    * @param protocolType
    *           the protocolType to set
    */
   public void setProtocolType(ProtocolType protocolType) {
      this.protocolType = protocolType;
   }

   /**
    * @return the protocolLength
    */
   public ProtocolLength getProtocolLength() {
      return protocolLength;
   }

   /**
    * @param protocolLength
    *           the protocolLength to set
    */
   public void setProtocolLength(ProtocolLength protocolLength) {
      this.protocolLength = protocolLength;
   }

   /**
    * @return the hardwareLength
    */
   public HardwareLength getHardwareLength() {
      return hardwareLength;
   }

   /**
    * @param hardwareLength
    *           the hardwareLength to set
    */
   public void setHardwareLength(HardwareLength hardwareLength) {
      this.hardwareLength = hardwareLength;
   }

   /**
    * @return the arpOption
    */
   public ArpOption getArpOption() {
      return arpOption;
   }

   /**
    * @param arpOption
    *           the arpOption to set
    */
   public void setArpOption(ArpOption arpOption) {
      this.arpOption = arpOption;
   }

   /**
    * @return the sendMac
    */
   public MacAddress getSendMac() {
      return sendMac;
   }

   /**
    * @param sendMac
    *           the sendMac to set
    */
   public void setSendMac(MacAddress sendMac) {
      this.sendMac = sendMac;
   }

   /**
    * @return the sendIp
    */
   public Ipv4Address getSendIp() {
      return sendIp;
   }

   /**
    * @param sendIp
    *           the sendIp to set
    */
   public void setSendIp(Ipv4Address sendIp) {
      this.sendIp = sendIp;
   }

   /**
    * @return the recvMac
    */
   public MacAddress getRecvMac() {
      return recvMac;
   }

   /**
    * @param recvMac
    *           the recvMac to set
    */
   public void setRecvMac(MacAddress recvMac) {
      this.recvMac = recvMac;
   }

   /**
    * @return the recvIp
    */
   public Ipv4Address getRecvIp() {
      return recvIp;
   }

   /**
    * @param recvIp
    *           the recvIp to set
    */
   public void setRecvIp(Ipv4Address recvIp) {
      this.recvIp = recvIp;
   }

   public String toString() {
      String result = "";
      result += hardwareType;
      result += protocolType;
      result += hardwareLength;
      result += protocolLength;
      result += arpOption;
      result += sendMac;
      result += sendIp;
      result += recvMac;
      result += recvIp;
      return result;
   }
}
