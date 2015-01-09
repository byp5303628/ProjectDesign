package project.soft.session;

import java.util.ArrayList;

import project.protocol.header.Packet;
import project.soft.aspf.Aspf;
import project.soft.handle.PacketForwarder;

/**
 * Created by ypbai on 2014/12/25.
 */
public class SessionTable implements PacketForwarder, SessionHandler {

   private ArrayList<SessionItem> sessionList;

   public SessionTable() {
      this.sessionList = new ArrayList<SessionItem>();
   }

   @Override
   public void forward(Packet packet) {

   }

   @Override
   public SessionItem match(Packet packet) {
      for (SessionItem si : sessionList) {
         if (si.match(packet)) {
            return si;
         }
      }
      return null;
   }

   @Override
   public void updateSessionTable(Packet packet) {
      SessionItem item = match(packet);
   }

   @Override
   public void display() {

   }
}
