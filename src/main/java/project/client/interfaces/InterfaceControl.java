package project.client.interfaces;

import project.hard.interf.InterfaceInfo;

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
   public void shutDown(InterfaceInfo interfaceInfo);

   /**
    * Start up interface
    */
   public void startUp(InterfaceInfo interfaceInfo);
}
