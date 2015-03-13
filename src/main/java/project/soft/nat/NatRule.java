package project.soft.nat;

import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.datagram.layer4.Port;
import project.protocol.header.Packet;
import project.soft.acl.Acl;
import project.soft.util.Range;

/**
 * Created by ypbai on 2015/3/13.
 */
public abstract class NatRule implements NatInter {
   private Acl acl;
   private NatBuilder natBuilder;


   protected boolean match(Packet packet) {
      return acl.match(packet);
   }

   public void setAcl(Acl acl) {
      this.acl = acl;
   }

   class NatBuilder {
      public Range<Ipv4Address> ipOriginRange;
      public Range<Port> portOriginRange;
      public Range<Ipv4Address> ipChangedRange;
      public Range<Port> portChangedRange;
   }
}
