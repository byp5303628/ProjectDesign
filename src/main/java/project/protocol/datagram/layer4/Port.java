package project.protocol.datagram.layer4;

import project.soft.util.RangeInter;

/**
 * Created by ypbai on 2015/1/5.
 */
public class Port implements RangeInter<Port> {
   /*
    * By default, it is 1024
    */
   private String port;

   public Port() {
      this("0400");
   }

   /**
    * Init port number through number.
    * 
    * @param port
    */
   public Port(int port) {
      setPort(port);
   }

   /**
    * Check if two port equals
    *
    * @param o
    * @return
    */
   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (!(o instanceof Port))
         return false;

      Port port1 = (Port) o;

      if (!port.equals(port1.port))
         return false;

      return true;
   }

   @Override
   public int hashCode() {
      return port.hashCode();
   }

   public Port(String port) {
      this.port = port;
   }

   public String getPort() {
      return port;
   }

   public int getPortNum() {
      return Integer.parseInt(port, 16);
   }

   public void setPort(String port) {
      while (port.length() < 4) {
         port = "0" + port;
      }
      this.port = port;
   }

   public void setPort(int port) {
      setPort(Integer.toHexString(port));
   }

   /**
    * Get the num string of the port number.
    * 
    * @return
    */
   public String toString() {
      return Integer.toString(getPortNum());
   }

   @Override
   public int compareTo(Port o) {
      return getPortNum() - o.getPortNum();
   }

   @Override
   public Port generateRandomItem(Port end) {
      return null;
   }
}
