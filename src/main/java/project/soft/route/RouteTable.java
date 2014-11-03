package project.soft.route;

import java.util.ArrayList;
import java.util.Collections;

import project.hard.interf.InterfaceInfo;
import project.protocol.datagram.layer3.ip.Ipv4Address;

public class RouteTable {
   private ArrayList<RouteItem> routeList;

   public RouteTable() {
      this.routeList = new ArrayList<RouteItem>();
   }

   public void updateRouteTable() {

   }

   /**
    * Insert Route Item into routing table, if it is already exists, refresh the
    * routing table, then refresh the routing table
    * 
    * @param target
    *           , which is the dest ip address
    * @param mask
    *           , which is the mask
    * @param type
    *           , static or dynamic
    * @param inter
    *           , which interface is relative
    */
   public void insertRouteItem(Ipv4Address target, int mask, String type,
         InterfaceInfo inter) {
      RouteItem e = new RouteItem();
      e.setMask(mask);
      e.setTarget(target);
      e.setType(type);
      e.setOutputInterface(inter);

      // if item in the list
      RouteItem tar = findRouteItem(e);
      if (tar != null) {
         tar.setType(type);
         tar.setOutputInterface(inter);
         return;
      }
      this.routeList.add(e);

      // refresh the routing table
      Collections.sort(this.routeList);
   }

   /**
    * Find route item in the rilist, if in, return the obj, else, return null
    * 
    * @param obj
    * @return
    */
   private RouteItem findRouteItem(RouteItem obj) {
      for (RouteItem ri : this.routeList) {
         if (obj.equals(ri)) {
            return ri;
         }
      }
      return null;
   }

   /**
    * Get the output interface from specific target ip address, if not exist,
    * return null
    * 
    * @param target
    * @return
    */
   public InterfaceInfo getOutputInterface(Ipv4Address target) {
      for (RouteItem ri : this.routeList) {
         if (ri.match(target)) {
            return ri.getOutputInterface();
         }
      }

      return null;
   }

   /**
    * Delete a route item if it exists
    * 
    * @param obj
    */
   public void deleteRouteItem(Ipv4Address ip, int mask) {
      RouteItem r = new RouteItem();
      r.setTarget(ip);
      r.setMask(mask);
      RouteItem ri = findRouteItem(r);
      if (ri != null) {
         this.routeList.remove(ri);
      }
   }
   
   public void displayRouteTable(){
      System.out.println("---Routing Table---");
      for (RouteItem ri:this.routeList){
         System.out.println(ri.toString());
      }
   }
}
