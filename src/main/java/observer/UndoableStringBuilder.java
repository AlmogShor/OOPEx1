package observer;

/*
Use the class you've implemented in previous assignment
 */

import java.util.Stack;

interface Action {
    void undo();
}

/**
 * A class to read numbers and strings from standard input with an undo option.
 *
 * @author Almog Shor -207900440 and Yulia Katz - 324385509
 * @version 1.0
 * @see java.util.Stack,java.lang.StringBuilder, java.lang.String
 * @since 2022-03-01
 */

public class UndoableStringBuilder implements Ex0UndoableStringBuilder {
    private String str;
    Stack<String> undoStrs;
    int undoIndex;
    private StringBuilder stringBuilder; // delegate
    /**
     * Operations that are the reverse of those performed.
     * That is, when append is called, it is placed on the stack
     * "delete" operation. When calling undo() it
     * will be executed.
     */
    private Stack<Action> actions = new Stack<>();

    // constructor

    /**
     * Constructs a string builder with no characters in it and an initial capacity of 16 characters.
     */
    public UndoableStringBuilder() {
        this.stringBuilder = new StringBuilder();

        //Our additions
        this.undoStrs = new Stack<String>();
        undoIndex = 0;
        this.str = "";
    }


    //C'tr with a string - Our addition

    /**
     * Constructs a string builder with no characters in it and an initial capacity specified by the user.
     *
     * @param str - user specified initial capacity
     */
//    public UndoableStringBuilder(String str) {
//        this.str = str;
//        this.undoStrs = new Stack<String>();
//        this.undoIndex = 0;
//    }

    /**
     * Causes this character sequence to be replaced by the reverse of the sequence.
     *
     * @return - a reference to this object
     * @see Ex0UndoableStringBuilder#reverse()
     */
    public UndoableStringBuilder reverse() {
        stringBuilder.reverse();
        Action action = new Action() {
            public void undo() {
                stringBuilder.reverse();
            }
        };
        actions.add(action);
        return this;
        //our solution
        /*
         undoStrs.push(this.str);
        undoIndex++;
        this.str = new StringBuilder(this.str).reverse().toString();
        return this;
         */
    }

    /**
     * Appends the specified string to this character sequence.
     *
     * @param str - the string that is appended to the end of this character sequence
     * @return - a reference to this object
     * @throws NullPointerException - looking for "null" entering and don't accept it as append
     * @see Ex0UndoableStringBuilder#append(java.lang.String)
     */
    public UndoableStringBuilder append(String str) {
        stringBuilder.append(str);

        Action action = new Action() {
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length() - str.length(),
                        stringBuilder.length());
            }
        };
        actions.add(action);
        return this;
        //our solution
        /*
        try {
            if (!(str.equals(""))) {
                undoStrs.push(this.str);
                undoIndex++;
                this.str += str;
            }
        } catch (Exception e) {
            if (e.getClass().toString().equals("class java.lang.NullPointerException")) {
                System.out.println("got'ya, you entered null value");
                e.printStackTrace();//Full track to exactly did the error happen.
            }
        }
        return this;
         */
    }

    /**
     * Inserts the string into this character sequence.
     *
     * @param offset - the offset
     * @param str    - a string
     * @return * @exception StringIndexOutOfBoundsException
     * * @exception  StringIndexOutOfBoundsException if the start smaller bigger then the string length, we do nothing/
     * @see Ex0UndoableStringBuilder#insert(int, java.lang.String)
     */
    public UndoableStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        Action action = new Action() {
            public void undo() {
                stringBuilder.delete(offset, offset + str.length());
            }
        };
        actions.add(action);
        return this;
        //our solution
        /*
         try {
            undoStrs.push(this.str);
            undoIndex++;
            this.str = this.str.substring(0, offset) + str + this.str.substring(offset); // not sure if this is the best way to do it. or they want it just opposite
            return this;
        } catch (StringIndexOutOfBoundsException e) {
            if (e.getClass().toString().equals("class java.lang.StringIndexOutOfBoundsException")) {
                System.out.println("Not valid range, we will take it from here it's your lucky day");
                //We will subtract the operation counted in the try and count again if there is a fix
                this.str = undoStrs.pop();
                this.undoIndex--;

                e.printStackTrace();
                if (this.str.length() <= offset) {
                    undoStrs.push(this.str);
                    undoIndex++;
                    this.str = this.str + str; // not sure if this is the best way to do it. or they want it just opposite
                    return this;
                }
                if (offset < 0) {
                    offset = Math.abs(offset);
                    this.insert(offset, str);
                }
            }
        } catch (NullPointerException e) {
            if (e.getClass().toString().equals("class java.lang.NullPointerException")) {
                System.out.println("got'ya, you entered null value");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Well done, you found an exception that we didn't hand with");
            System.out.println(e.getClass().toString());
            e.printStackTrace();

        } finally {
            return this;
        }
         */
    }

    /**
     * Removes the characters in a substring of this sequence.
     * The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     *
     * @param start - the beginning index, inclusive
     * @param end   - the ending index, exclusive
     * @return - a reference to this object
     * @throws StringIndexOutOfBoundsException we fix cases of negative, opposite values, end bigger then the current string.
     * @throws StringIndexOutOfBoundsException if the start smaller bigger then the string length, we do nothing/
     * @see Ex0UndoableStringBuilder#delete(int, int)
     */
    public UndoableStringBuilder delete(int start, int end) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        Action action = new Action() {
            public void undo() {
                stringBuilder.insert(start, deleted);
            }
        };
        actions.add(action);
        return this;
        //our solution
        /*
        try {
            undoStrs.push(this.str);
            undoIndex++;
            this.str = this.str.substring(0, start) + this.str.substring(end); // not sure if this is the best way to do it, or they want it just opposite
            return this;
        } catch (Exception e) {
            if (e.getClass().toString().equals("class java.lang.StringIndexOutOfBoundsException")) {
                this.str = undoStrs.pop();
                this.undoIndex--;
                e.printStackTrace();
                System.out.println("Not valid range, we will take it from here it's your lucky day");
                if (this.str.length() < end && this.str.length() > start) {
                    //case where it is required to delete characters up to more than the length of the string
                    end = this.str.length() - 1;
                    undoStrs.push(this.str);
                    undoIndex++;
                    this.str = this.str.substring(0, start) + this.str.substring(end + 1); // not sure if this is the best way to do it. or they want it just opposite
                    return this;
                } else if (start < 0 || end < 0) {
                    end = Math.abs(end);
                    start = Math.abs(start);
                    this.delete(start, end);
                } else if (start > end) {
                    this.delete(end, start);
                } else if (this.str.length() < start)
                    //case where it is required to delete characters starting at a place higher than the length of the string
                    return this;
            }
        } finally {
            return this;
        }
         */
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in the specified String.
     * The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists.
     * First the characters in the substring are removed and then the specified String is inserted at start.
     * (This sequence will be lengthened to accommodate the specified String if necessary).
     *
     * @param start - the beginning index, inclusive
     * @param end   - the ending index, exclusive
     * @param str   - String that will replace previous
     * @return - a reference to this object
     * @throws StringIndexOutOfBoundsException we fix cases of negative, opposite values, end bigger then the current strings length.
     * @see Ex0UndoableStringBuilder#replace(int, int, java.lang.String)
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.replace(start, end, str);
        Action action = new Action() {
            public void undo() {
                stringBuilder.replace(start, start + str.length(), deleted);
            }
        };
        actions.add(action);
        return this;
        //our solution
        /*
        try {
            undoStrs.push(this.str);
            undoIndex++;
            this.str = this.str.substring(0, start) + str + this.str.substring(end); // not sure if this is the best way to do it. or they want it just opposite
            return this;
        } catch (Exception e) {
            if (e.getClass().toString().equals("class java.lang.StringIndexOutOfBoundsException")) {
                System.out.println("Not valid range, we will take it from here it's your lucky day");
                e.printStackTrace();
                if (this.str.length() > start && this.str.length() < end) {
                    undoStrs.push(this.str);
                    undoIndex++;
                    this.str = this.str.substring(0, start) + str + this.str.substring(end);
                }
                if (this.str.length() < start) {
                    undoStrs.push(this.str);
                    undoIndex++;
                    this.insert(this.str.length(), str);
                    //case where it is required to delete characters starting at a place higher than the length of the string
                    return this;
                }
                if (str.equals("")) {
                    System.out.println("There is nothing to replace");
                }
                if (start < 0 || end < 0) {
                    end = Math.abs(end);
                    start = Math.abs(start);
                    this.replace(start, end, str);
                }
                if (start > end) {
                    this.replace(end, start, str);
                }
                if (e.getClass().toString().equals("class java.lang.NullPointerException")) {
                    System.out.println("got'ya, you entered null value");
                }
            }
        } finally {
            return this;
        }
         */
    }

    /**
     * Undo the last operation.
     * If there is no operation to undo, the method does nothing.
     *
     * @see Ex0UndoableStringBuilder#undo()
     */
    public void undo() {
        if (!actions.isEmpty()) {
            actions.pop().undo();
        }
        //Our additions
        if (undoIndex == 0) {
            return;
        }
        this.undoIndex--;
    }

    /**
     * Prints the string.
     *
     * @return - the string representation of the object.
     * @see Ex0UndoableStringBuilder#toString()
     */
    public String toString() {
        return stringBuilder.toString();
        //our solution
        /*
        return this.str;
         */
    }


    /**
     * get the undo Index
     *
     * @return - the undo index
     */
    public int getUndoIndex() {
        return undoIndex;
    }

    /**
     * get the undo stack of previous strings
     *
     * @return - the undo stack
     */
    public Stack<String> getUndoStrs() {
        return this.undoStrs;
    }
}

