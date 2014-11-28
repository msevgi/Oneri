package com.ikar.oneri.model;

import java.util.ArrayList;


public class Category {
    private String name;
    private ArrayList<String> childList;

    public Category() {
    }


    public Category(String name, ArrayList<String> childList) {
        this.name = name;
        this.childList = childList;
    }

    public ArrayList<String> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<String> childList) {
        this.childList = childList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
