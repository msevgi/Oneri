package com.ikar.oneri.event;

/**
 * Created by mustafasevgi on 09/11/14.
 */
public class LeftChildItemClickEvent {
    private int groupPosition;
    private int childPosition;

    public LeftChildItemClickEvent(int groupPosition, int childPosition) {
        this.groupPosition = groupPosition;
        this.childPosition = childPosition;
    }

    public int getGroupPosition() {
        return groupPosition;
    }

    public void setGroupPosition(int groupPosition) {
        this.groupPosition = groupPosition;
    }

    public int getChildPosition() {
        return childPosition;
    }

    public void setChildPosition(int childPosition) {
        this.childPosition = childPosition;
    }
}
