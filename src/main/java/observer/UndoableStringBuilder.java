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

class UndoableStringBuilder implements Ex0UndoableStringBuilder {


    private StringBuilder stringBuilder; // delegate
    /**
     * Operations that are the reverse of those performed.
     * That is, when append is called, it is placed on the stack
     * "delete" operation. When calling undo() it
     * will be executed.
     */
    private Stack<Action> actions = new Stack<>();

    // constructor

    public UndoableStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    @Override
    public UndoableStringBuilder reverse() {
        stringBuilder.reverse();
        Action action = new Action() {
            public void undo() {
                stringBuilder.reverse();
            }
        };
        actions.add(action);
        return this;
    }

    @Override
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
    }

    @Override
    public UndoableStringBuilder insert(int offset, String str) {
        try {

            stringBuilder.insert(offset, str);
            int finalOffset = offset;
            Action action = new Action() {
                public void undo() {
                    stringBuilder.delete(finalOffset, finalOffset + str.length());
                }
            };
            actions.add(action);
        } catch (StringIndexOutOfBoundsException e) {
            if (this.stringBuilder.length() <= offset) {
                //case where it is required to delete characters up to more than the length of the string
                this.stringBuilder.append(str);
                int finalOffset1 = offset;
                Action action = new Action() {
                    public void undo() {
                        stringBuilder.delete(finalOffset1, finalOffset1 + str.length());
                    }
                };
            } else if (offset < 0) {
                offset = Math.abs(offset);
                this.insert(offset, str);
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

        }
        return this;
    }

    @Override
    public UndoableStringBuilder delete(int start, int end) {

        try {
            String deleted = stringBuilder.substring(start, end);
            stringBuilder.delete(start, end);
            int finalStart = start;
            Action action = new Action() {
                public void undo() {
                    stringBuilder.insert(finalStart, deleted);
                }
            };
            actions.add(action);
        } catch (StringIndexOutOfBoundsException e) {
            if (this.stringBuilder.length() < end && this.stringBuilder.length() > start) {
                //case where it is required to delete characters up to more than the length of the string
                end = this.stringBuilder.length();
                this.delete(start, end);
            } else if (start < 0 || end < 0) {
                end = Math.abs(end);
                start = Math.abs(start);
                this.delete(start, end);

            } else if (start > end) {
                this.delete(end, start);
            } else if (this.stringBuilder.length() < start)
                //case where it is required to delete characters starting at a place higher than the length of the string
                return this;
        }


        return this;
    }

    @Override
    public UndoableStringBuilder replace(int start, int end, String str) {
        try {

            String deleted = stringBuilder.substring(start, end);
            stringBuilder.replace(start, end, str);
            int finalStart = start;
            Action action = new Action() {
                public void undo() {
                    stringBuilder.replace(finalStart, finalStart + str.length(), deleted);
                }
            };
            actions.add(action);
        } catch (StringIndexOutOfBoundsException e) {
            if (this.stringBuilder.length() < end && this.stringBuilder.length() > start) {
                //case where it is required to delete characters up to more than the length of the string
                end = this.stringBuilder.length();
                this.replace(start, end, str);
            } else if (start < 0 || end < 0) {
                end = Math.abs(end);
                start = Math.abs(start);
                this.replace(start, end, str);

            } else if (start > end) {
                this.replace(end, start, str);
            } else if (this.stringBuilder.length() < start)
                //case where it is required to delete characters starting at a place higher than the length of the string
                this.append(str);
        } catch (NullPointerException e) {
            if (e.getClass().toString().equals("class java.lang.NullPointerException")) {
                System.out.println("got'ya, you entered null value");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Well done, you found an exception that we didn't hand with");
            System.out.println(e.getClass().toString());
            e.printStackTrace();

        }
        return this;
    }

    @Override
    public void undo() {
        if (!actions.isEmpty()) {
            actions.pop().undo();
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    public Stack<Action> getActions() {
        return actions;
    }
}

