package org.sciddi.hotel.model;

import java.time.LocalDate;


public class Visitor {
    private int id;
    private String fullname;
    private String email;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Room room;


    public Visitor(int id, String fullname, String email, LocalDate checkInDate, LocalDate checkOutDate) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", room=" + room +
                '}';
    }
}


