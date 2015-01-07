package project.soft.session;

import project.protocol.header.Packet;

/**
 * Created by ypbai on 2014/12/25.
 */
public interface SessionHandler {
   /**
    * Check if the packet mathches the session table, if not, create session
    * item and update session table.
    * 
    * @param packet
    * @return
    */
   public boolean match(Packet packet);
}
