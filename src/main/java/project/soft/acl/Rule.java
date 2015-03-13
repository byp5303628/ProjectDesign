package project.soft.acl;

import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.datagram.layer4.Port;
import project.protocol.header.Packet;
import project.soft.util.Range;

/**
 * Created by ypbai on 2015/3/13.
 */
public class Rule implements Comparable<Rule> {
   private int index;

   private RuleBuilder rb = new RuleBuilder();

   private Rule() {
   }

   public static Rule makeRuleThroughString(int index) {
      Ipv4Address srcIp = new Ipv4Address();
      Ipv4Address destIp = new Ipv4Address();
      Port srcP = new Port();
      Port destP = new Port();
      Rule r = new Rule();

      return r;
   }

   public void setIndex(int index) {
      this.index = index;
   }

   public int getIndex() {
      return this.index;
   }

   public boolean match(Packet packet) {
      return false;
   }

   @Override
   public int compareTo(Rule o) {
      return this.index - o.getIndex();
   }

   class RuleBuilder {
      public Range<Ipv4Address> srcIpRange;
      public Range<Ipv4Address> destIpRange;
      public Range<Port> srcPortRange;
      public Range<Port> destPortRange;

      public RuleBuilder setSrcIpRange(Ipv4Address start, Ipv4Address end) {
         this.srcIpRange = new Range<Ipv4Address>(start, end);
         return this;
      }

      public RuleBuilder setDestIpRange(Ipv4Address start, Ipv4Address end) {
         this.destIpRange = new Range<Ipv4Address>(start, end);
         return this;
      }

      public RuleBuilder setSrcPortRange(Port start, Port end) {
         this.srcPortRange = new Range<Port>(start, end);
         return this;
      }

      public RuleBuilder setDestPortRange(Port start, Port end) {
         this.destPortRange = new Range<Port>(start, end);
         return this;
      }
   }
}
