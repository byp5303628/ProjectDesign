package project.soft.arp;

import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.datagram.layer3.ip.Ipv4Address;


/**
 * Created by ypbai on 2014/12/25.
 */
public class ArpItem {
    private Ipv4Address ip;
    private MacAddress mac;


    public MacAddress getMac() {
        return mac;
    }

    public void setMac(MacAddress mac) {
        this.mac = mac;
    }

    public Ipv4Address getIp() {
        return ip;
    }

    public void setIp(Ipv4Address ip) {
        this.ip = ip;
    }
}
