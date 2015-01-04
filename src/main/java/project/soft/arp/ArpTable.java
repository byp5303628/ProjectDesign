package project.soft.arp;

import java.util.ArrayList;

import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;
import project.protocol.header.Packet;
import project.protocol.header.layer3.Arp;
import project.soft.handle.TableHandler;

/**
 * Created by ypbai on 2014/12/25.
 */
public class ArpTable implements TableHandler<ArpItem> {
   private ArrayList<ArpItem> arpList;

   public ArpTable() {
      this.arpList = new ArrayList<ArpItem>();
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

   /**
    * Display the entire arp table
    */
   @Override
   public void display() {
      System.out.println("---- ARP Table ----");
      for (ArpItem ai : arpList) {
         System.out.println(ai.toString());
      }
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
      insertItem(item);
   }

   @Override
   public ArpItem getItem(ArpItem item) {
      if (!arpList.contains(item)) {
         return null;
      }
      return item;
   }

   /**
    * When receive a arp response, update the arp table.
    * 
    * @param packet
    */
   public void updateArpTable(Packet packet) {
      // do packet arp check
      Arp arp = (Arp) packet.getL3();
      ArpItem ai = new ArpItem();
      ai.setIp(arp.getSendIp());
      ai.setMac(arp.getSendMac());
      updateItem(ai);
   }

   /**
    * Query mac address from arp table, if find, return mac address, else return
    * null
    * 
    * @param ipv4Address
    * @return
    */
   public MacAddress queryMacAddress(Ipv4Address ipv4Address) {
      for (ArpItem ai : arpList) {
         if (ai.getIp().equals(ipv4Address)) {
            return ai.getMac();
         }
      }

      return null;
   }
}
