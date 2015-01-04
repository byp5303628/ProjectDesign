package project.client.route;

import project.protocol.datagram.layer3.ip.Ipv4Address;

/**
 * Created by ypbai on 2015/1/4.
 */
public interface RouteControl {
   /**
    * Manually set a static route to lead how to route packets.
    * 
    * @param target
    *           , which is the destination ip address
    * @param mask
    *           , which is the mask
    * @param nextHop
    *           , which is the next hot ip address
    */
   public void updateRouteTable(Ipv4Address target, int mask,
         Ipv4Address nextHop);

   /**
    * Display the route table.
    */
   public void displayRouteTable();
}
