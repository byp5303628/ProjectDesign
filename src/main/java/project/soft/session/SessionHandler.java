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
   public SessionItem match(Packet packet);

   /**
    * Update session table, if cannot find session item in session table, do
    * ASPF check and create new item push it to the session table.
    * 
    * @param packet
    *           , which is the input packet
    */
   public void updateSessionTable(Packet packet);
}
