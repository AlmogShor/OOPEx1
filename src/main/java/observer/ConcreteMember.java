package observer;


public class ConcreteMember implements Member {
    //This is the Observer class
    private UndoableStringBuilder usb;
    private GroupAdmin ourBoss;



    /**
     * @param boss - The GroupAdmin
     */
    public ConcreteMember(GroupAdmin boss) {
        this.ourBoss = boss;
        this.ourBoss.register(this);
        this.ourBoss.notifyAllObservers();
    }

    /**
     * @param usb
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb; // Is this the right way to do it? Or should i ask for an update from ourBoss? or the post should call this func?
        System.out.println("The UndoableStringBuilder has been updated to: " + this.usb.toString());
    }

    public boolean register() {
        return this.ourBoss.register(this);
    }
    public boolean unregister() {
        try {
            this.ourBoss.unregister(this);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public UndoableStringBuilder getUsb() {
        return usb;
    }

    protected void setUsb(UndoableStringBuilder usb) {
        this.usb = usb;
    }

    public GroupAdmin getOurBoss() {
        return ourBoss;
    }

    public void setOurBoss(GroupAdmin ourBoss) {
        this.ourBoss = ourBoss;
    }
}

