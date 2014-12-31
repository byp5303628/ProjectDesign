package project.soft.mac;

import project.protocol.header.Packet;
import project.soft.handle.PacketForwarder;
import project.soft.handle.TableHandler;

/**
 * Created by ypbai on 2014/12/29.
 */
public class MacTable implements TableHandler<MacItem>, PacketForwarder {

   @Override
   public void insertItem(MacItem item) {

   }

   @Override
   public void display() {

   }

   @Override
   public void deleteItem(MacItem item) {

   }

   @Override
   public void updateItem(MacItem item) {

   }

   @Override
   public MacItem getItem(MacItem item) {
      return null;
   }

   @Override
   public void forward(Packet packet) {

   }
}
