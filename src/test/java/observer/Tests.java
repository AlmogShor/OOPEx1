package observer;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;


public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    public UndoableStringBuilder usb1 = new UndoableStringBuilder("Hello");

    public UndoableStringBuilder usb2 = new UndoableStringBuilder("Boss");
    public GroupAdmin boss = new GroupAdmin(usb1);
    public ConcreteMember member1 = new ConcreteMember(boss);
    public ConcreteMember member2 = new ConcreteMember(boss);
    public ConcreteMember member3 = new ConcreteMember(boss);
    public ConcreteMember member4 = new ConcreteMember(boss);
    public ConcreteMember member5 = new ConcreteMember(boss);
    public GroupAdmin boss2 = new GroupAdmin(usb2);
    public ConcreteMember memberV2_1 = new ConcreteMember(boss2);
    public ConcreteMember memberV2_2 = new ConcreteMember(boss2);
    public ConcreteMember memberV2_3 = new ConcreteMember(boss2);
    public ConcreteMember memberV2_4 = new ConcreteMember(boss2);
    public ConcreteMember memberV2_5 = new ConcreteMember(boss2);

    @Test
    public void test1() {
        logger.info(() -> "Test 1: Inserting 5 members to the same GroupAdmin");
        logger.info(() -> "Expected: 5 members in the GroupAdmin");
        logger.info(() -> "Actual: " + boss.getMemberList().size());
//        System.out.println(boss.getMemberList().size());
        assert (boss.getMemberList().size() == 5);
    }

    @Test
    public void test_getUsbDB() {
        logger.info(() -> "Test 2: Getting the UndoableStringBuilder from the GroupAdmin");
        logger.info(() -> "Expected: " + usb1);
        logger.info(() -> "Actual: " + boss.getUsbDB());
        assert (boss.getUsbDB() == usb1);
    }

    @Test
    public void test_setUsbDB() {
        logger.info(() -> "Test 3: Setting the UndoableStringBuilder from the GroupAdmin");
        logger.info(() -> "Expected: " + usb2);
        logger.info(() -> "Actual: " + boss2.getUsbDB());
        assert (boss2.getUsbDB() == usb2);
    }

    @Test
    public void test_register() {
        logger.info(() -> "Test 4: Registering a new member to the GroupAdmin");
        boss.register(memberV2_5);
        logger.info(() -> "Expected: 6 members in the GroupAdmin");
        logger.info(() -> "Actual: " + boss.getMemberList().size());
        assert (boss.getMemberList().size() == 6);
        boss.unregister(memberV2_5);
    }

    @Test
    public void test_unregister() {
        logger.info(() -> "Test 5: Unregistering a member from the GroupAdmin");
        logger.info(() -> "Expected: 5 members in the GroupAdmin");
        logger.info(() -> "Actual: " + boss.getMemberList().size());
        assert (boss.getMemberList().size() == 5);
    }

    @Test
    public void test_notifyAllObservers() {
        logger.info(() -> "Test 6: Notifying all observers of the GroupAdmin");
        logger.info(() -> "Expected: member no 1 has the same UndoableStringBuilder as the GroupAdmin");
        logger.info(() -> "Actual: " + member1.getUsb());
        assert (member1.getUsb() == boss.getUsbDB());
        logger.info(() -> "Expected: member no 2 has the same UndoableStringBuilder as the GroupAdmin");
        logger.info(() -> "Actual: " + member2.getUsb());
        assert (member2.getUsb() == boss.getUsbDB());
        logger.info(() -> "Expected: member no 3 has the same UndoableStringBuilder as the GroupAdmin");
        logger.info(() -> "Actual: " + member3.getUsb());
        assert (member3.getUsb() == boss.getUsbDB());
        logger.info(() -> "Expected: member no 4 has the same UndoableStringBuilder as the GroupAdmin");
        logger.info(() -> "Actual: " + member4.getUsb());
        assert (member4.getUsb() == boss.getUsbDB());
        logger.info(() -> "Expected: member no 5 has the same UndoableStringBuilder as the GroupAdmin");
        logger.info(() -> "Actual: " + member5.getUsb());
        assert (member5.getUsb() == boss.getUsbDB());

    }

    @Test
    public void test() {
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(() -> JvmUtilities.objectFootprint(s1));

        logger.info(() -> JvmUtilities.objectFootprint(s1, s2));

        logger.info(() -> JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }


}
