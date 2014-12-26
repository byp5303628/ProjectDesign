package project.soft.session;

import project.protocol.header.Packet;
import project.soft.handle.PacketForwarder;
import project.soft.handle.TableHandler;

import java.util.ArrayList;

/**
 * Created by ypbai on 2014/12/25.
 */
public class SessionTable implements PacketForwarder, SessionHandler, TableHandler<SessionItem> {

    private ArrayList<SessionItem> sessionList;

    public SessionTable() {
        this.sessionList = new ArrayList<SessionItem>();
    }

    @Override
    public void forward(Packet packet) {

    }

    @Override
    public void insertItem(SessionItem item) {

    }

    @Override
    public void display() {

    }

    @Override
    public void deleteItem(SessionItem item) {

    }

    @Override
    public void updateItem(SessionItem item) {

    }

    @Override
    public SessionItem getItem(SessionItem item) {
        return null;
    }

    @Override
    public boolean match(Packet packet) {
        return false;
    }
}
