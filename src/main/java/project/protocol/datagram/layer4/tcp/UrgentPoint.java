package project.protocol.datagram.layer4.tcp;

/**
 * Created by ypbai on 2015/1/6.
 */
public class UrgentPoint {
   private String urgentPoint;

   public UrgentPoint() {
      this("0000");
   }

   public UrgentPoint(String urgentPoint) {
      this.urgentPoint = urgentPoint;
   }

   public String getUrgentPoint() {
      return urgentPoint;
   }

   public void setUrgentPoint(String urgentPoint) {
      this.urgentPoint = urgentPoint;
   }
}
