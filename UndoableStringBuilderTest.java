import static org.junit.jupiter.api.Assertions.*;

class UndoableStringBuilderTest {
    Ex0UndoableStringBuilder ST = new UndoableStringBuilder();
    Ex0UndoableStringBuilder act = new UndoableStringBuilder();



    @org.junit.jupiter.api.Test
    void undo() {
        ST.append("Let it be");
        ST.delete(1,3);
        ST.undo();
        assertEquals(ST.toString(),"Let it be");
        ST.insert(3, " fucking");
        assertEquals(ST.toString(),"Let fucking it be");
        ST.undo();
        assertEquals(ST.toString(),"Let it be");
        ST.delete(1,3);
        ST.insert(7,"gine");
        assertEquals(ST.toString(),"L it begine");
        ST.undo();
        assertEquals(ST.toString(),"L it be");


    }

    @org.junit.jupiter.api.Test
    void append() {
        ST.append(null);
        assertEquals(ST.toString(), "");
        ST.append("");//Enter nothing
        assertEquals(ST.getUndoIndex(), 0);//Nothing for undo function
        ST.append("Now i enter something good");
        assertEquals(ST.getUndoIndex(), 1);
        ST.undo();
        assertEquals(ST.toString(), "");

    }

    @org.junit.jupiter.api.Test
    void delete() {
        //Checking if the function is carried out properly
        ST.append("Yulia");
        ST.delete(1, 3);
        assertEquals(ST.toString(), "Yia");
        assertEquals(ST.getUndoIndex(), 2);
        ST.delete(1, 9);
        assertEquals(ST.getUndoIndex(),3);
        ST.undo();
        assertEquals(ST.toString(),"Yia");
        ST.delete(4,7);
        assertEquals(ST.getUndoIndex(), 2);


    }

    @org.junit.jupiter.api.Test
    void insert() {
        //Checking if the function is carried out properly
        ST.append("Yulia");
        ST.insert(2, "l");
        assertEquals(ST.toString(), "Yullia");//middle insert
        ST.insert(6, " Vahnish"); //append
        assertEquals(ST.toString(), "Yullia Vahnish");
        //Checks for a case where it is required to insert characters up to more than the length of the string
        ST.insert(23, "Queen");
        assertEquals(ST.toString(), "Yullia VahnishQueen");
        assertEquals(ST.getUndoIndex(),4);

    }

    @org.junit.jupiter.api.Test
    void replace() {
        //Checking if the function is carried out properly
        ST.append("Yulia");
        ST.replace(2, 4, "lllll");
        assertEquals(ST.toString(), "Yullllla");//middle insert
        ST.replace(2, 6, " ");
        assertEquals(ST.toString(), "Yu la");//middle insert
        ST.replace(23, 28, "Queen");
        assertEquals(ST.toString(), "Yu laQueen");

    }

    @org.junit.jupiter.api.Test
    void reverse() {
        ST.append("Yulia");
        assertEquals(ST.reverse().toString(), "ailuY");

    }
}