package org.sciddi.hotel.model;

public class RoomType {
    private int id;
    private String name;

    public RoomType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RoomType{id=" + id + ", name='" + name + "'}";
    }
}

