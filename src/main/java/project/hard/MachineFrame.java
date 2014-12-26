package project.hard;

import java.util.ArrayList;

import project.exceptions.BoardExistingException;
import project.exceptions.BoardNotExistingException;
import project.exceptions.SlotNotExistException;
import project.hard.board.Board;
import project.protocol.header.Packet;
import project.soft.arp.ArpTable;
import project.soft.route.RouteTable;

public class MachineFrame {
    /*
     * The boards can hang on the Machine Frame. Each Machine Frame have several
     * slots, for this one, have 10 slots. Each slot can get MasterBoard or
     * FunctionBoard or InterfaceBoard
     */
    private int slotNumber;
    private ArrayList<Board> boardList;

    /**
     * Need to add access from the interfaceInfo, such as insert, query, delete
     * One Machine Frame has only one routeTable
     */
    private RouteTable routeTable;

    private ArpTable arpTable;

    public void forwardThroughRouteTable(Packet packet){
        routeTable.forward(packet);
    }

    public MachineFrame(){
        this(10);
    }

    public MachineFrame(int slotNumber) {
        this.slotNumber = slotNumber;
        this.boardList = new ArrayList<Board>();
        for (int i = 0; i < slotNumber; i++) {
            this.boardList.add(null);
        }
        this.routeTable = new RouteTable();
        this.arpTable = new ArpTable();
    }

    /**
     * Insert a board to a specific slot
     *
     * @param slotNum , which is the specific slot number we want to insert
     * @param board   , which is the board
     * @throws BoardExistingException
     * @throws SlotNotExistException
     */
    public void insertBoard(int slotNum, Board board)
            throws BoardExistingException, SlotNotExistException {
        if (this.getBoard(slotNum) == null) {
            this.boardList.add(slotNum, board);
            board.setSlot(slotNum);
        } else {
            throw new BoardExistingException(slotNum);
        }
    }

    /**
     * Query the specific slot number's board, if not exist, return null
     *
     * @param slotNum , which is the specific slot number we want to query
     * @return
     * @throws SlotNotExistException
     */
    public Board getBoard(int slotNum) throws SlotNotExistException {
        if (0 <= slotNum && slotNum < this.slotNumber)
            return this.boardList.get(slotNum);
        else {
            throw new SlotNotExistException(slotNum);
        }
    }

    /**
     * Remove the specific slot number's board
     *
     * @param slotNum , which is the specific slot number we want to insert
     * @throws BoardNotExistingException
     * @throws SlotNotExistException
     */
    public void deleteBoard(int slotNum) throws BoardNotExistingException,
            SlotNotExistException {
        if (this.getBoard(slotNum) == null) {
            throw new BoardNotExistingException(slotNum);
        }
        this.boardList.add(slotNum, null);
    }

    /**
     * Display the session of the machine frame
     */
    public void displaySessions() {
        for (int i = 0; i < this.slotNumber; i++) {
            System.out.println("Slot " + i + ":");
            this.boardList.get(i).displaySession();
        }
    }

    public int getSlotNumber() {
        return this.slotNumber;
    }


    public void sessionBackup() {
        // (TODO: Ethan)
    }

    public ArpTable getArpTable() {
        return arpTable;
    }

    public void setArpTable(ArpTable arpTable) {
        this.arpTable = arpTable;
    }

    public void displayRouteTable(){
        routeTable.display();
    }
}
