package project.soft.route;

import project.hard.interf.InterfaceInfo;
import project.protocol.datagram.layer3.ip.Ipv4Address;

public class RouteItem implements Comparable<RouteItem> {
   private Ipv4Address target;
   private int mask;
   private Ipv4Address nextHop;
   private InterfaceInfo outputInterface;
   private String type;

   public RouteItem() {
   }

   /**
    * Given a ip address return if it matches the RouteItem
    *
    * @param dest
    * @return
    */
   public boolean match(Ipv4Address dest) {
      // first, get the string of the
      int a = mask / 4;
      String ri = this.target.getIp().substring(0, a);
      String de = dest.getIp().substring(0, a);

      return ri.equals(de);
   }

   /**
    * Compare two route item, check if they equals. Only compare the target ip
    * address, mask, next hop address.
    *
    * @param obj
    * @return
    */
   @Override
   public boolean equals(Object obj) {
      if (obj == null)
         return false;
      return this.target.equals(((RouteItem) obj).getTarget())
            && this.mask == ((RouteItem) obj).getMask();
   }

   public Ipv4Address getTarget() {
      return target;
   }

   public void setTarget(Ipv4Address target) {
      this.target = target;
   }

   public InterfaceInfo getOutputInterface() {
      return outputInterface;
   }

   public void setOutputInterface(InterfaceInfo outputInterface) {
      this.outputInterface = outputInterface;
   }

   public int getMask() {
      return mask;
   }

   public void setMask(int mask) {
      this.mask = mask;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String toString() {
      StringBuffer result = new StringBuffer(this.target.getPointString());
      result.append("  ");
      result.append(this.mask);
      result.append("  ");
      result.append(this.nextHop);
      result.append("  ");
      result.append(this.outputInterface.getName());
      result.append("  ");
      result.append(this.type);
      return result.toString();
   }

   public int compareTo(RouteItem o) {
      // TODO Auto-generated method stub
      //int m = 8 - this.mask;
      String s1 = this.getTarget().getIp().substring(0, this.mask / 4);
      String s2 = o.getTarget().getIp().substring(0, this.mask / 4);
      return s2.compareTo(s1);
   }

   public Ipv4Address getNextHop() {
      return nextHop;
   }

   public void setNextHop(Ipv4Address nextHop) {
      this.nextHop = nextHop;
   }
}
