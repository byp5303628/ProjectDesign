package project.protocol.header;

import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.header.layer2.Ethernet;
import project.protocol.header.layer2.Layer2;
import project.protocol.header.layer3.Layer3;
import project.protocol.header.layer3.Layer3Protocol;
import project.protocol.header.layer4.Layer4;

public class Packet {
    private Layer2 l2;
    private Layer3 l3;
    private Layer4 l4;

    /**
     * Check the layer3's protocol
     *
     * @return
     */
    public Layer3Protocol getLayer3() {
        if (((Ethernet) l2).getFrameType().getFrameType() == "0800") {
            return Layer3Protocol.IP;
        } else if (((Ethernet) l2).getFrameType().getFrameType() == "0806") {
            return Layer3Protocol.ARP;
        } else {
            return Layer3Protocol.INVALID_PROTOCOL;
        }
    }

    /**
     * Get the packet's Dest mac
     *
     * @return
     */
    public MacAddress getDestMac() {
        return ((Ethernet) (this.l2)).getDestMac();
    }

    public Layer3 getL3() {
        return l3;
    }

    public void setL3(Layer3 l3) {
        this.l3 = l3;
    }

    public Layer2 getL2() {
        return l2;
    }

    public void setL2(Layer2 l2) {
        this.l2 = l2;
    }

    public Layer4 getL4() {
        return l4;
    }

    public void setL4(Layer4 l4) {
        this.l4 = l4;
    }

    public String toString() {
        if (this.l4 != null) {
            String result = this.l2.toString() + this.l3.toString();
            return result;
        } else {
            String result =
                    this.l2.toString() + this.l3.toString() + this.l4.toString();
            return result;
        }
    }
}
