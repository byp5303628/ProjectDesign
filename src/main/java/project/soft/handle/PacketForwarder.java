package project.soft.handle;

import project.protocol.header.Packet;

/**
 * Created by ypbai on 2014/12/25.
 */
public abstract interface PacketForwarder {
    /**
     * For soft tables, let them forward packet and give it to another device to handleIn.
     *
     * @param packet
     */
    public abstract void forward(Packet packet);
}
