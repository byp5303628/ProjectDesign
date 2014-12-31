package project.soft.arp;

import junit.framework.Assert;

import org.testng.annotations.Test;

import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;

/**
 * Created by ypbai on 2014/12/31.
 */
public class ArpTableTest {

   @Test
   public void testInsertMacToArp() {
      ArpTable arpTable = new ArpTable();
      arpTable.insertMacToArp(new Ipv4Address("01010202"),
            MacAddress.makeBraodcastMacAddress());
      ArpItem ai = new ArpItem();
      ai.setMac(MacAddress.makeBraodcastMacAddress());
      ai.setIp(new Ipv4Address("01010202"));

      Assert.assertNotNull(arpTable.getItem(ai));
   }

   @Test
   public void testInsertItem() {
      ArpTable arpTable = new ArpTable();
      ArpItem arpItem = new ArpItem();
      arpItem.setIp(new Ipv4Address("01010202"));
      arpItem.setMac(MacAddress.makeMacAddress());
      arpTable.insertItem(arpItem);
      arpTable.insertItem(arpItem);
   }

   @Test
   public void testQuery() {
      ArpTable arpTable = new ArpTable();
      arpTable.insertMacToArp(new Ipv4Address("01010202"),
            MacAddress.makeBraodcastMacAddress());
      ArpItem ai = new ArpItem();
      ai.setMac(MacAddress.makeBraodcastMacAddress());
      ai.setIp(new Ipv4Address("01010202"));

      Assert.assertEquals(
            arpTable.queryMacAddress(new Ipv4Address("01010202")),
            MacAddress.makeBraodcastMacAddress());

      Assert.assertNull(arpTable.queryMacAddress(new Ipv4Address("01010203")));
   }

   @Test
   public void testUpdate() {
      ArpTable arpTable = new ArpTable();
      // after update, get the exist item
      ArpItem ai = new ArpItem();
      ai.setIp(new Ipv4Address("01010203"));
      ai.setMac(MacAddress.makeMacAddress());
      arpTable.updateItem(ai);
      Assert.assertEquals(arpTable.getItem(ai), ai);

      ai.setIp(new Ipv4Address("01010203"));
      ai.setMac(MacAddress.makeBraodcastMacAddress());
      arpTable.updateItem(ai);
      Assert.assertEquals(MacAddress.makeBraodcastMacAddress(),
            arpTable.queryMacAddress(new Ipv4Address("01010203")));
   }

   @Test
   public void testDelete() {
      ArpTable arpTable = new ArpTable();
      arpTable.insertMacToArp(new Ipv4Address("01010202"),
            MacAddress.makeBraodcastMacAddress());
      ArpItem ai = new ArpItem();
      ai.setMac(MacAddress.makeBraodcastMacAddress());
      ai.setIp(new Ipv4Address("01010202"));

      Assert.assertNotNull(arpTable.getItem(ai));

      arpTable.deleteItem(ai);
      Assert.assertNull(arpTable.getItem(ai));
   }

   @Test
   public void testDisplay() {
      ArpTable arpTable = new ArpTable();
      arpTable.insertMacToArp(new Ipv4Address("01010202"),
            MacAddress.makeBraodcastMacAddress());
      arpTable.display();
   }
}
