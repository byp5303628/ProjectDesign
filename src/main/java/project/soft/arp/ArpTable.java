package project.soft.arp;

import java.util.ArrayList;

import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.header.Packet;
import project.soft.handle.PacketForwarder;
import project.soft.handle.TableHandler;

/**
 * Created by ypbai on 2014/12/25.
 */
public class ArpTable implements PacketForwarder, TableHandler<ArpItem> {
   private ArrayList<ArpItem> arpList;

   public ArpTable() {
      this.arpList = new ArrayList<ArpItem>();
   }


   @Override
   public void forward(Packet packet) {
      return;
   }

   public void insertMacToArp(Ipv4Address ip, MacAddress mac) {
      ArpItem ai = new ArpItem();
      ai.setIp(ip);
      ai.setMac(mac);
      insertItem(ai);
   }


   @Override
   public void insertItem(ArpItem item) {
      if (!arpList.contains(item)) {
         arpList.add(item);
      }
   }

   @Override
   public void display() {

   }

   @Override
   public void deleteItem(ArpItem item) {
      arpList.remove(item);
   }

   @Override
   public void updateItem(ArpItem item) {
      int index = 0;
      for (ArpItem ai : arpList) {
         if (ai.getIp().equals(item.getIp())) {
            arpList.remove(index);
            arpList.add(index, item);
            return;
         }
         index++;
      }
   }

   @Override
   public ArpItem getItem(ArpItem item) {
      if (!arpList.contains(item)) {
         return null;
      }
      return item;
   }

   public void updateArpTable(Packet packet) {

   }
}
