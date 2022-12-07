package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender{
    //This is the Observable class

    private ArrayList<UndoableStringBuilder> usbDB = new ArrayList<UndoableStringBuilder>();
    private ArrayList memberList;


    public GroupAdmin(UndoableStringBuilder usb) {
        this.usbDB.add(usb);
        this.memberList = new ArrayList();
    }
    /**
     * @param obj
     */
    @Override
    public void register(Member obj) {
        this.memberList.add(obj);

    }

    /**
     * @param obj
     */
    @Override
    public void unregister(Member obj) {
        this.memberList.remove(obj);
    }

    /**
     * @param offset
     * @param obj
     */
    @Override
    public void insert(int offset, String obj) {

    }

    /**
     * @param obj
     */
    @Override
    public void append(String obj) {

    }

    /**
     * @param start
     * @param end
     */
    @Override
    public void delete(int start, int end) {

    }

    /**
     *
     */
    @Override
    public void undo() {

    }
}
