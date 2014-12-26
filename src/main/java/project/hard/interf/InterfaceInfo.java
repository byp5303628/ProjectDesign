package project.hard.interf;

import project.hard.board.InterfaceBoard;
import project.protocol.datagram.layer2.ethernet.MacAddress;
import project.protocol.header.Packet;
import project.protocol.header.layer3.Layer3Protocol;
import project.soft.handle.PacketHandler;

public class InterfaceInfo implements PacketHandler {
    @Override
    public void handleIn(Packet packet) {
        if (packet.getDestMac().isBroadcast()) {
            // First if it is a broadcast packet, check if it is a arp request
            if (packet.getLayer3().equals(Layer3Protocol.ARP)) {
                // Send Arp response with current interface's info
                sendArpResponse();
                return;
            } else {
                // This is not a arp response, drop it
                return;
            }
        } else if (packet.getDestMac().equals(this.getAddr())) {
            // This is the destination, send response
            switch (packet.getLayer3()) {
                case ARP:
                    return;
                case IP:
                    // (TODO: Ethan)
                    return;
                case INVALID_PROTOCOL:
                    return;
            }
        } else {
            // This is not the destination, forward it through mac table
            getBoard().getMachineFrame().forwardThroughRouteTable(packet);
        }
    }

    @Override
    public void handleOut(Packet packet) {

    }

    static public enum Mode {
        Bridge, Route,
    }

    private MacAddress addr;
    private String name;
    private String description;
    private Mode mode;
    private InterfaceInfo linkedTo;
    private InterfaceBoard board;
    private String status;
    /**
     * Used for user control, user could set it up and down to control its status
     */
    private String updown;

    /**
     * Process packet
     */
    public void processPacket(Packet packet) {

    }

    private void forwardPacket(Packet packet) {
        // TODO Auto-generated method stub

    }

    private void sendArpResponse() {
        // TODO Auto-generated method stub

    }

    public MacAddress getAddr() {
        return addr;
    }

    public void setAddr(MacAddress addr) {
        this.addr = addr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public InterfaceInfo getLinkedTo() {
        return linkedTo;
    }

    public void setLinkedTo(InterfaceInfo linkedTo) {
        this.linkedTo = linkedTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdown() {
        return updown;
    }

    public void setUpdown(String updown) {
        this.updown = updown;
    }

    public InterfaceBoard getBoard() {
        return board;
    }

    public void setBoard(InterfaceBoard board) {
        this.board = board;
    }
}
