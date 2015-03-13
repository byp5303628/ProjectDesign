package project.soft.nat;

import project.protocol.header.Packet;
import project.soft.session.ARROW;

/**
 * Created by ypbai on 2015/3/13.
 */
public interface NatInter {

   public void update(Packet p, ARROW arrow);
}
