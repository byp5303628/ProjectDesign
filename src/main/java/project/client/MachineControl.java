package project.client;

import project.client.board.BoardControl;
import project.client.interfaces.InterfaceControl;
import project.client.route.RouteControl;

/**
 * Created by ypbai on 2015/1/4.
 */
public interface MachineControl extends InterfaceControl, RouteControl,
        BoardControl {
   /**
    * Boot up a Machine Frame
    */
   public void bootMachine();

   /**
    * Shut down a Machine Frame
    */
   public void shutDownMachine();

   /**
    * Do one machine session backup.
    */
   public void sessionBackUp();
}
