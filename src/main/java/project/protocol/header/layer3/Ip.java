package project.protocol.header.layer3;

import project.protocol.datagram.layer3.ip.*;

public class Ip extends Layer3 {
   private TypeLength typeLength;
   private Tos tos;
   private TotalLength totalLength;
   private Identification identification;
   private FlagFragment flagFragment;
   private Ttl ttl;
   private InternetType internetType;
   private Checksum checksum;
   private Ipv4Address srcAddr;
   private Ipv4Address destAddr;

   public Ip() {
      this.typeLength = new TypeLength();
      this.tos = new Tos();
      this.totalLength = new TotalLength();
      this.identification = new Identification();
      this.flagFragment = new FlagFragment();
      this.ttl = new Ttl();
      this.internetType = new InternetType();
      this.checksum = new Checksum();
      this.srcAddr = new Ipv4Address();
      this.destAddr = new Ipv4Address();
   }

   public String toString() {
      String result = "";
      result += this.typeLength;
      result += this.tos;
      result += this.totalLength;
      result += this.identification;
      result += this.flagFragment;
      result += this.ttl;
      result += this.internetType;
      result += this.checksum;
      result += this.srcAddr;
      result += this.destAddr;
      return result;
   }

   /**
    * Judge if the packet matches the route.
    * 
    * @param ip
    *           , target route
    * @param mask
    *           , mask bits
    * @return
    */
   public boolean matchRoute(Ipv4Address ip, int mask) {
      return this.destAddr.getIp().substring(0, mask)
            .equals(ip.getIp().subSequence(0, mask));
   }

   public TypeLength getTypeLength() {
      return typeLength;
   }

   public void setTypeLength(TypeLength typeLength) {
      this.typeLength = typeLength;
   }

   public Tos getTos() {
      return tos;
   }

   public void setTos(Tos tos) {
      this.tos = tos;
   }

   public TotalLength getTotalLength() {
      return totalLength;
   }

   public void setTotalLength(TotalLength totalLength) {
      this.totalLength = totalLength;
   }

   public Identification getIdentification() {
      return identification;
   }

   public void setIdentification(Identification identification) {
      this.identification = identification;
   }

   public FlagFragment getFlagFragment() {
      return flagFragment;
   }

   public void setFlagFragment(FlagFragment flagFragment) {
      this.flagFragment = flagFragment;
   }

   public Ttl getTtl() {
      return ttl;
   }

   public void setTtl(Ttl ttl) {
      this.ttl = ttl;
   }

   public Checksum getChecksum() {
      return checksum;
   }

   public void setChecksum(Checksum checksum) {
      this.checksum = checksum;
   }

   public Ipv4Address getSrcAddr() {
      return srcAddr;
   }

   public void setSrcAddr(Ipv4Address srcAddr) {
      this.srcAddr = srcAddr;
   }

   public Ipv4Address getDestAddr() {
      return destAddr;
   }

   public void setDestAddr(Ipv4Address destAddr) {
      this.destAddr = destAddr;
   }

   public InternetType getInternetType() {
      return internetType;
   }

   public void setInternetType(InternetType internetType) {
      this.internetType = internetType;
   }
}
