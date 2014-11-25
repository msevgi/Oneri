package com.ikar.oneri.event;

/**
 * Created by mustafasevgi on 09/11/14.
 */
public class LeftGroupImageClickEvent {
    private int groupPosition;

    public LeftGroupImageClickEvent(int groupPosition) {
        this.groupPosition = groupPosition;
    }

    public int getGroupPosition() {
        return groupPosition;
    }


    public void setGroupPosition(int groupPosition) {
        this.groupPosition = groupPosition;
    }


}
