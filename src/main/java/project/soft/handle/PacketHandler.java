package project.soft.handle;

import project.protocol.header.Packet;

/**
 * Created by ypbai on 2014/12/25.
 */
public abstract interface PacketHandler {
    /**
     * For hard devices, let them handle input packet and give it to another device to handle.
     *
     * @param packet
     */
    public abstract void handleIn(Packet packet);

    /**
     * For hard devices, let them handle output packet and forward out.
     * @param packet
     */
    public abstract void handleOut(Packet packet);
}
