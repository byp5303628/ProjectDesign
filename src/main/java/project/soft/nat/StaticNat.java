package project.soft.nat;

import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.datagram.layer4.Port;
import project.protocol.header.Packet;
import project.soft.session.ARROW;

/**
 * Created by ypbai on 2015/3/13.
 */
public class StaticNat extends NatRule {

   private StaticNat() {
   }

   public static StaticNat makeStaticNat(Ipv4Address originIP,
         Ipv4Address changedIp, Port originPort, Port changedPort) {
      StaticNat sn = new StaticNat();

      return sn;
   }

   @Override
   public void update(Packet p, ARROW arrow) {
      if (this.match(p)) {
         if (arrow == ARROW.IN) {


         } else {


         }
      }
   }
}