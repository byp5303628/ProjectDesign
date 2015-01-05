package project.protocol.datagram.layer4;

/**
 * Created by ypbai on 2015/1/5.
 */
public class Port {
   /*
    * By default, it is 1024
    */
   private String port;

   public Port() {
      this("0400");
   }

   /**
    * Check if two port equals
    * 
    * @param obj
    * @return
    */
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      return port.equals(((Port) obj).getPort());
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
      this.port = port;
   }

   public void setPort(int port) {
      this.port = Integer.toHexString(port);
   }

   /**
    * Get the num string of the port number.
    * 
    * @return
    */
   public String toString() {
      return Integer.toString(getPortNum());
   }
}
