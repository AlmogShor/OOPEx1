package observer;

public interface Sender {
    //methods to register and unregister observers //Just like Add in Ex0
    void register(Member obj);
    void unregister(Member obj);
    //Inserts the string into this character sequence. //Just like remove in Ex0
    void insert(int offset, String obj);
    // Appends the specified string to this character sequence.
    void append(String obj);
    // Removes the characters in a substring of this sequence.
    void delete(int start, int end);
    // Erases the last change done to the document, reverting
    // it to an older state.
    void undo();
}
