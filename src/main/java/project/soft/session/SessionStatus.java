package project.soft.session;

/**
 * Created by ypbai on 2015/1/6.
 */
public enum SessionStatus {
   //Tcp status
   TCP_SYN_INIT,
   TCP_SYN_INIT2,
   TCP_SYN_RECV,
   TCP_EST,
   TCP_CLOSE,
   TCP_CLOSE_WAIT,
   TCP_RST,
   // Udp status
   UDP_OPEN,
   UDP_READY,
   UDP_CLOSE,
   // Raw ip status
   RAW_IP_OPEN,
   RAW_IP_READY,
   RAW_IP_CLOSE,
}
