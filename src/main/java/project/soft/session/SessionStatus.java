package project.soft.session;

/**
 * Created by ypbai on 2015/1/6.
 */
public enum SessionStatus {
   //Tcp status
   TCP_SYN_INIT("TCP_SYN_INIT"),
   TCP_SYN_INIT2("TCP_SYN_INIT2"),
   TCP_SYN_RECV("TCP_SYN_RECV"),
   TCP_EST("TCP_EST"),
   TCP_CLOSE("TCP_CLOSE"),
   TCP_CLOSE_WAIT("TCP_CLOSE_WAIT"),
   TCP_RST("TCP_RST"),
   // Udp status
   UDP_OPEN("UDP_OPEN"),
   UDP_READY("UDP_READY"),
   UDP_CLOSE("UDP_CLOSE"),
   // Raw ip status
   RAW_IP_OPEN("RAW_IP_OPEN"),
   RAW_IP_READY("RAW_IP_READY"),
   RAW_IP_CLOSE("RAW_IP_CLOSE");

   private String sessionStatus;

   SessionStatus(String sessionStatus) {
      this.sessionStatus = sessionStatus;
   }

   public String toString() {
      return this.sessionStatus;
   }
}
