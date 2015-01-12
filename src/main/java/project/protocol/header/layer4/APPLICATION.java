package project.protocol.header.layer4;

/**
 * Created by ypbai on 2015/1/5.
 */
public enum APPLICATION {
   FTP("FTP"),
   DNS("DNS"),
   TELNET("TELNET"),
   UNKNOWN_APPLICATION("UNKNOWN_APPLICATION");

   private String application;

   APPLICATION(String a) {
      this.application = a;
   }

   @Override
   public String toString() {
      return super.toString();
   }
}
