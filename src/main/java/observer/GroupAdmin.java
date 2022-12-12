package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender {
    //This is the Observable class

    private UndoableStringBuilder usbDB = new UndoableStringBuilder();
    private ArrayList memberList;

    public UndoableStringBuilder getUsbDB() {
        return usbDB;
    }

    public void setUsbDB(UndoableStringBuilder usbDB) {
        this.usbDB = usbDB;
    }

    public ArrayList getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList memberList) {
        this.memberList = memberList;
    }

    public GroupAdmin(UndoableStringBuilder usb) {
        this.usbDB = usb;
        this.memberList = new ArrayList<ConcreteMember>();
    }

    /**
     * @param obj
     */
    @Override
    public void register(Member obj) {
        if (obj instanceof ConcreteMember) {
            this.memberList.add((ConcreteMember) obj);
        } else {
            System.out.println("Error: Not a ConcreteMember, its just a Member of " + obj.getClass().getName());
        }

    }

    /**
     * @param obj
     */
    @Override
    public void unregister(Member obj) {
        if (obj instanceof ConcreteMember) {
            this.memberList.remove((ConcreteMember) obj);
        } else {
            System.out.println("Error: Not a ConcreteMember, its just a Member of " + obj.getClass().getName());
        }
    }

    public void notifyAllObservers() {
        for (int i = 0; i < this.memberList.size(); i++) {
            ((ConcreteMember) this.memberList.get(i)).update(this.usbDB);
        }
    }

    /**
     * @param offset
     * @param obj
     */
    @Override
    public void insert(int offset, String obj) {
        this.usbDB.insert(offset, obj);
        notifyAllObservers();
    }

    /**
     * @param obj
     */
    @Override
    public void append(String obj) {
        this.usbDB.append(obj);
        notifyAllObservers();
    }

    /**
     * @param start
     * @param end
     */
    @Override
    public void delete(int start, int end) {
        this.usbDB.delete(start, end);
        notifyAllObservers();
    }

    /**
     *
     *
     */
    @Override
    public void undo() {
        this.usbDB.undo();
        notifyAllObservers();
    }
}
