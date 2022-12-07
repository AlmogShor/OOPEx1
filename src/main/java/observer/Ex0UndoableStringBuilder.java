package observer;

/**
 * An Interface to read numbers and strings from standard input with an undo option.
 *
 * @author Almog Shor -207900440 and Yulia Katz - 324385509
 * @version 1.0
 * @since 2022-03-01
 */
public interface Ex0UndoableStringBuilder {

    /**
     * Undo the last operation.
     *
     * @return
     */
    public void undo();

    /**
     * Appends the specified string to this character sequence.
     *
     * @param str
     * @return
     */
    public UndoableStringBuilder append(String str);

    /**
     * Removes the characters in a substring of this sequence.
     * The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     *
     * @param start
     * @param end
     * @return
     */
    public UndoableStringBuilder delete(int start, int end);

    /**
     * Inserts the string into this character sequence.
     *
     * @param offset
     * @param str
     * @return
     */
    public UndoableStringBuilder insert(int offset, String str);

    /**
     * Replaces the characters in a substring of this sequence with characters in the specified String.
     * The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists.
     * First the characters in the substring are removed and then the specified String is inserted at start.
     * (This sequence will be lengthened to accommodate the specified String if necessary).
     *
     * @param start
     * @param end
     * @param str
     * @return
     */
    public UndoableStringBuilder replace(int start, int end, String str);

    /**
     * Causes this character sequence to be replaced by the reverse of the sequence.
     *
     * @return
     */
    public UndoableStringBuilder reverse();

    /**
     * Prints the string.
     *
     * @return
     */
    public String toString();

    int getUndoIndex();
}
