package observer;

public class ConcreteMember implements Member {
    //This is the Observer class
    private UndoableStringBuilder usb;
    private GroupAdmin ourBoss;

    /**
     *
     * @param usb
     */
    public ConcreteMember(UndoableStringBuilder usb, GroupAdmin boss) {
        this.usb = usb;
        this.ourBoss = boss;
        this.ourBoss.register(this);
    }

    /**
     *
     * @param usb
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb; // Is this the right way to do it? Or should i ask for an update from ourBoss? or the post should call this func?
        System.out.println("StringBuilderObserver: " + usb);
    }
}

