package project.soft.nat;

/**
 * Created by ypbai on 2015/3/13.
 */
public class NatConfig {
   private NatServer natServer;
   private StaticNat staticNat;
   private NatOutbound natOutbound;



   public NatServer getNatServer() {
      return natServer;
   }

   public void setNatServer(NatServer natServer) {
      this.natServer = natServer;
   }

   public StaticNat getStaticNat() {
      return staticNat;
   }

   public void setStaticNat(StaticNat staticNat) {
      this.staticNat = staticNat;
   }

   public NatOutbound getNatOutbound() {
      return natOutbound;
   }

   public void setNatOutbound(NatOutbound natOutbound) {
      this.natOutbound = natOutbound;
   }
}
