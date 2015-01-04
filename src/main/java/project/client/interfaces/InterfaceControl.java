package project.client.interfaces;

/**
 * Created by ypbai on 2015/1/4.
 */
public interface InterfaceControl {
   /**
    * Set an interface's ip address
    * 
    * @param pointString
    * @param mask
    */
   public void setIpv4Address(String pointString, int mask);

   /**
    * Shut down interface
    */
   public void shutDown();

   /**
    * Start up interface
    */
   public void startUp();
}
