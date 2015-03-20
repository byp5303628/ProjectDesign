package project.soft.route;

import project.hard.interf.InterfaceInfo;
import project.hard.interf.RouteInterfaceInfo;
import project.protocol.datagram.layer3.ip.Ipv4Address;

public class RouteItem implements Comparable<RouteItem> {
   private Ipv4Address target;
   private int mask;
   private Ipv4Address nextHop;
   private RouteInterfaceInfo outputInterface;

   public ROUTE_TYPE getType() {
      return type;
   }

   public void setType(ROUTE_TYPE type) {
      this.type = type;
   }

   private ROUTE_TYPE type;

   public RouteItem() {
      this.type = ROUTE_TYPE.STATIC;
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

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (!(o instanceof RouteItem))
         return false;

      RouteItem routeItem = (RouteItem) o;

      if (mask != routeItem.mask)
         return false;
      if (!target.equals(routeItem.target))
         return false;
      if (type != routeItem.type)
         return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = target.hashCode();
      result = 31 * result + mask;
      result = 31 * result + type.hashCode();
      return result;
   }

   public Ipv4Address getTarget() {
      return target;
   }

   public void setTarget(Ipv4Address target) {
      this.target = target;
   }

   public RouteInterfaceInfo getOutputInterface() {
      return outputInterface;
   }

   public void setOutputInterface(InterfaceInfo outputInterface) {
      this.outputInterface = (RouteInterfaceInfo) outputInterface;
   }

   public int getMask() {
      return mask;
   }

   public void setMask(int mask) {
      this.mask = mask;
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

   /**
    * Which is used to help collection run the sort function.
    * 
    * @param o
    *           , which is the other route item compared to.
    * @return
    */
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
      // first check out the route table
      this.nextHop = nextHop;
   }
}
