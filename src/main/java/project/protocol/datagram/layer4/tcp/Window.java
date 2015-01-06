package project.protocol.datagram.layer4.tcp;

/**
 * Created by ypbai on 2015/1/6.
 */
public class Window {
   private String window;

   public Window() {
      this("0000");
   }

   public Window(String window) {
      this.window = window;
   }

   public String getWindow() {
      return window;
   }

   public void setWindow(String window) {
      this.window = window;
   }
}
