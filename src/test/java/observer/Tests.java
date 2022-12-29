package observer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

import observer.*;


public class Tests {
    final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    UndoableStringBuilder usb1 = new UndoableStringBuilder();
    UndoableStringBuilder usb2 = new UndoableStringBuilder();

    UndoableStringBuilder usb3 = new UndoableStringBuilder();
    GroupAdmin ga1 = new GroupAdmin(usb1);
    GroupAdmin ga_set_and_reg = new GroupAdmin();

    GroupAdmin ga3 = new GroupAdmin(usb3);
    ConcreteMember cm1 = new ConcreteMember(ga1);
    ConcreteMember cm2 = new ConcreteMember(ga1);
    ConcreteMember cm_reg_from_scratch = new ConcreteMember();
    ConcreteMember cm3 = new ConcreteMember(ga3);
    ConcreteMember cm4 = new ConcreteMember(ga3);
    ConcreteMember cm5 = new ConcreteMember(ga3);
    ConcreteMember cm6 = new ConcreteMember(ga3);
    ConcreteMember cm7 = new ConcreteMember(ga3);
    //    ConcreteMember cm8 = new ConcreteMember(ga3);
//    ConcreteMember cm9 = new ConcreteMember(ga3);
//    ConcreteMember cm10 = new ConcreteMember(ga3);
//    ConcreteMember cm11 = new ConcreteMember(ga3);
//    ConcreteMember cm12 = new ConcreteMember(ga3);


    @Test
    public void testOfSetUSBAndRegNewMem() {
        logger.info(() -> "Testing setUsb() method");
        ga_set_and_reg.setUsbDB(usb2);
        assertEquals(usb2, ga_set_and_reg.getUsbDB());
        ga_set_and_reg.register(cm_reg_from_scratch);
        ga_set_and_reg.append("Hello");
        assertEquals("Hello", cm_reg_from_scratch.getUsb().toString());
        assertEquals(ga_set_and_reg.getUsbDB(), cm_reg_from_scratch.getUsb());
    }

    @Test
    public void testOfRegister() {
        logger.info(() -> "Testing register() method");
        ga1.register(cm1);
        ga1.register(cm2);
        ga1.register(cm_reg_from_scratch);
        assertTrue(ga1.getMemberList().contains(cm1));
        assertTrue(ga1.getMemberList().contains(cm2));
        assertTrue(ga1.getMemberList().contains(cm_reg_from_scratch));

    }

    @Test
    public void testOfUnregister() {
        logger.info(() -> "Testing unregister() method");
        ga1.unregister(cm1);
        ga1.unregister(cm2);
        ga1.unregister(cm_reg_from_scratch);
        assertFalse(ga1.getMemberList().contains(cm1));
        assertFalse(ga1.getMemberList().contains(cm2));
        assertFalse(ga1.getMemberList().contains(cm_reg_from_scratch));
    }

    @Test
    public void testOfAppend() {
        logger.info(() -> "Testing append() method");

        ga3.append("Hello");
        assertEquals("Hello", cm3.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm3.getUsb());
        assertEquals("Hello", cm4.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm4.getUsb());
        assertEquals("Hello", cm5.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm5.getUsb());
        assertEquals("Hello", cm6.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm6.getUsb());
        assertEquals("Hello", cm7.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm7.getUsb());
    }

    @Test
    public void testOfUndo() {
        logger.info(() -> "Testing undo() method");
        ga3.append("Hello");
        ga3.append("World");
        ga3.undo();
        assertEquals("Hello", cm3.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm3.getUsb());
        assertEquals("Hello", cm4.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm4.getUsb());
        assertEquals("Hello", cm5.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm5.getUsb());
        assertEquals("Hello", cm6.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm6.getUsb());
        assertEquals("Hello", cm7.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm7.getUsb());
    }

    @Test
    public void testOfInsert() {
        logger.info(() -> "Testing insert() method");
        ga3.insert(0, "Hello");
        assertEquals("Hello", cm3.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm3.getUsb());
        assertEquals("Hello", cm4.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm4.getUsb());
        assertEquals("Hello", cm5.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm5.getUsb());
        assertEquals("Hello", cm6.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm6.getUsb());
        assertEquals("Hello", cm7.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm7.getUsb());
        assertDoesNotThrow(() -> ga3.insert(ga3.toString().length() + 100, "Hello"));
        assertDoesNotThrow(() -> ga3.insert(-1, "Hello"));
    }

    @Test
    public void testOfDelete() {
        logger.info(() -> "Testing delete() method");
        ga3.append("Hello");
        ga3.append("World");
        ga3.delete(0, 5);
        assertEquals("World", cm3.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm3.getUsb());
        assertEquals("World", cm4.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm4.getUsb());
        assertEquals("World", cm5.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm5.getUsb());
        assertEquals("World", cm6.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm6.getUsb());
        assertEquals("World", cm7.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm7.getUsb());
        assertDoesNotThrow(() -> ga3.delete(ga3.toString().length() + 100, 5));
        assertDoesNotThrow(() -> ga3.delete(-1, 5));
    }

    @Test
    public void testOfReplace() {
        logger.info(() -> "Testing replace() method");
        ga3.append("Hello");
        ga3.append("World");
        ga3.replace(0, 5, "Goodbye");
        assertEquals("GoodbyeWorld", cm3.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm3.getUsb());
        assertEquals("GoodbyeWorld", cm4.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm4.getUsb());
        assertEquals("GoodbyeWorld", cm5.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm5.getUsb());
        assertEquals("GoodbyeWorld", cm6.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm6.getUsb());
        assertEquals("GoodbyeWorld", cm7.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm7.getUsb());
    }

    @Test
    public void testOfGetMemberList() {
        logger.info(() -> "Testing getMemberList() method");
        ga_set_and_reg.register(cm1);
        ga_set_and_reg.register(cm2);
        ga_set_and_reg.register(cm_reg_from_scratch);
        assertTrue(ga_set_and_reg.getMemberList().contains(cm1));
        assertTrue(ga_set_and_reg.getMemberList().contains(cm2));
        assertTrue(ga_set_and_reg.getMemberList().contains(cm_reg_from_scratch));
    }

    @Test
    public void testOfReverse() {
        logger.info(() -> "Testing reverse() method");
        ga3.append("Hello");
        ga3.append("World");
        ga3.reverse();
        assertEquals("dlroWolleH", cm3.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm3.getUsb());
        assertEquals("dlroWolleH", cm4.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm4.getUsb());
        assertEquals("dlroWolleH", cm5.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm5.getUsb());
        assertEquals("dlroWolleH", cm6.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm6.getUsb());
        assertEquals("dlroWolleH", cm7.getUsb().toString());
        assertEquals(ga3.getUsbDB(), cm7.getUsb());
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

    @Test
    public void testOfJVMUtilities() {
        logger.info(() -> JvmUtilities.jvmInfo());
        assertDoesNotThrow(JvmUtilities::jvmInfo);
        //Tests for JVM info
        assertDoesNotThrow(() -> JvmUtilities.jvmInfo());
        assertDoesNotThrow(() -> JvmUtilities.memoryStats(ga1));
        assertDoesNotThrow(() -> JvmUtilities.objectTotalSize(ga1));
        assertDoesNotThrow(() -> JvmUtilities.objectFootprint(ga1));
        logger.info(() -> JvmUtilities.objectTotalSize(ga3));
        logger.info(() -> JvmUtilities.objectFootprint(ga3));
        logger.info(() -> JvmUtilities.memoryStats(ga3));
        ga3.append("JVM TEST");
        logger.info(() -> JvmUtilities.objectTotalSize(ga3));
        logger.info(() -> JvmUtilities.objectFootprint(ga3));
        logger.info(() -> JvmUtilities.memoryStats(ga3));
        ga3.delete(0, 8);
        logger.info(() -> JvmUtilities.objectTotalSize(ga3));
        logger.info(() -> JvmUtilities.objectFootprint(ga3));
        logger.info(() -> JvmUtilities.memoryStats(ga3));
        ga3.undo();
        logger.info(() -> JvmUtilities.objectTotalSize(ga3));
        logger.info(() -> JvmUtilities.objectFootprint(ga3));
        logger.info(() -> JvmUtilities.memoryStats(ga3));
        ga3.undo();
        logger.info(() -> JvmUtilities.objectTotalSize(ga3));
        logger.info(() -> JvmUtilities.objectFootprint(ga3));
        logger.info(() -> JvmUtilities.memoryStats(ga3));


    }

}
