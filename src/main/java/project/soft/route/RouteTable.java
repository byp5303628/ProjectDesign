package project.soft.route;

import java.util.ArrayList;
import java.util.Collections;

import project.hard.interf.InterfaceInfo;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.header.Packet;
import project.soft.handle.PacketForwarder;
import project.soft.handle.TableHandler;

public class RouteTable implements TableHandler<RouteItem>, PacketForwarder {
   private ArrayList<RouteItem> routeList;

   public RouteTable() {
      this.routeList = new ArrayList<RouteItem>();
   }

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

   public void deleteRouteItem(Ipv4Address ip, int mask) {
      RouteItem r = new RouteItem();
      r.setTarget(ip);
      r.setMask(mask);
      deleteItem(r);
   }

   @Override
   public void forward(Packet packet) {

   }

   @Override
   public void insertItem(RouteItem item) {
      RouteItem ri = getItem(item);

      if (ri != null) {
         routeList.add(item);
         Collections.sort(routeList);
      } else {
         updateItem(item);
      }
   }

   @Override
   public void display() {
      System.out.println("---Routing Table---");
      for (RouteItem ri : routeList) {
         System.out.println(ri.toString());
      }
   }

   @Override
   public void deleteItem(RouteItem item) {
      routeList.remove(item);
   }

   @Override
   public void updateItem(RouteItem item) {
      int index = 0;
      for (RouteItem ri : routeList) {
         if (item.getTarget().equals(ri.getTarget())
               && item.getNextHop().equals(ri.getNextHop())) {
            routeList.remove(index);
            routeList.add(index, item);
            return;
         }
         index++;
      }
   }

   @Override
   public RouteItem getItem(RouteItem item) {
      for (RouteItem ri : this.routeList) {
         if (item.equals(ri)) {
            return ri;
         }
      }
      return null;
   }
}
