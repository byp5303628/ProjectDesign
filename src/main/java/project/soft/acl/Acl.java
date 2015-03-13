package project.soft.acl;

import java.util.TreeMap;

import project.protocol.header.Packet;

/**
 * Created by ypbai on 2015/3/13.
 */
public class Acl implements AclInter {
   private TreeMap<Integer, Rule> rules = new TreeMap<Integer, Rule>();

   private int step = 5;
   private int bigIndex = 0;

   @Override
   public boolean match(Packet packet) {

      for (int i = rules.firstKey(); i != rules.lastKey(); i =
            rules.higherKey(i)) {
         if (rules.get(i).match(packet)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public void setRule(Rule r) {
      setRule(bigIndex + step, r);
   }

   @Override
   public void setRule(int index, Rule r) {
      if (index >= bigIndex) {
         bigIndex = index;
      }
      r.setIndex(index);
      rules.put(index, r);
   }

   @Override
   public void setStep(int step) {
      this.step = step;
   }
}
