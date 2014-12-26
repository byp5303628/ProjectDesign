package project.soft.session;

import project.protocol.header.Packet;

/**
 * Created by ypbai on 2014/12/25.
 */
public abstract interface SessionHandler {
    public boolean match(Packet packet);
}
