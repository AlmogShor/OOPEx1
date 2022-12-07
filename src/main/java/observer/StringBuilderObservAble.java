package observer;

import java.awt.*;
import java.util.ArrayList;

public class StringBuilderObservAble implements Sender{

    private Member member;
    private ArrayList memberList;


    public StringBuilderObservAble(Member member) {
        this.member = member;
        memberList = new ArrayList();
    }
    /**
     * @param obj
     */
    @Override
    public void register(Member obj) {

    }

    /**
     * @param obj
     */
    @Override
    public void unregister(Member obj) {

    }

    /**
     * @param offset
     * @param obj
     */
    @Override
    public void insert(int offset, String obj) {

    }

    /**
     * @param obj
     */
    @Override
    public void append(String obj) {

    }

    /**
     * @param start
     * @param end
     */
    @Override
    public void delete(int start, int end) {

    }

    /**
     *
     */
    @Override
    public void undo() {

    }
}
