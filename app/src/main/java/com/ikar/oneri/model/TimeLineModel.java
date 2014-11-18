package com.ikar.oneri.model;

/**
 * Created by mustafasevgi on 10/11/14.
 */
public class TimeLineModel {
    private int id;
    private String name;
    private String date;
    private String image_url;

    public TimeLineModel(int id, String name, String date, String image_url) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
