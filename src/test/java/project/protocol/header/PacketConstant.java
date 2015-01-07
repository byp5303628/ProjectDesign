package project.protocol.header;

/**
 * Created by ypbai on 2015/1/7.
 */
public final class PacketConstant {
   public static final String ETHERNET_IP_PACKET =
         "1524151526251524151526270800";
   public static final String ETHERNET_ARP_PACKET =
         "ffffffffffff1524151526250806";
   public static final String UDP_IP_PACKET =
         "4500001400000000ff110000c0a80101c0a80102";
   public static final String TCP_IP_PACKET =
         "4500001400000000ff060000c0a80101c0a80102";
   public static final String RAW_IP_PACKET =
         "4500001400000000ff200000c0a80101c0a80102";
   public static final String UDP_HEADER = "0400040100800000";
   public static final String TCP_HEADER =
         "0400040100000000000000000000000000000000";
}
