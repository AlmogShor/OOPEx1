package observer;

public class StringBuilderObserver implements Member {

    private UndoableStringBuilder usb;

    /**
     *
     * @param usb
     */
    public StringBuilderObserver(UndoableStringBuilder usb) {
        this.usb = usb;
    }

    /**
     *
     * @param usb
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        System.out.println("StringBuilderObserver: " + usb);
    }
}

