package project.soft.acl;

import project.protocol.header.Packet;

/**
 * Created by ypbai on 2015/3/13.
 */
public interface AclInter {
   /**
    * Judge if the acl matches a the rule.
    * 
    * @param packet
    * @return
    */
   public boolean match(Packet packet);

   /**
    * Set up a rule and put it into a
    * @param r
    */
   public void setRule(Rule r);

   public void setRule(int index, Rule r);

   public void setStep(int step);
}
