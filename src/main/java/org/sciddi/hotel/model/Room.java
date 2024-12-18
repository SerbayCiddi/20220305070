package org.sciddi.hotel.model;

import java.time.LocalDate;

public class Room {
    private int id;
    private String roomNumber;
    private LocalDate availableStartDate;
    private LocalDate availableEndDate;
    private RoomType roomType;

    public Room(int id, String roomNumber, LocalDate availableStartDate, LocalDate availableEndDate, RoomType roomType) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.availableStartDate = availableStartDate;
        this.availableEndDate = availableEndDate;
        this.roomType = roomType;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public LocalDate getAvailableStartDate() {
        return availableStartDate;
    }

    public LocalDate getAvailableEndDate() {
        return availableEndDate;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", availableStartDate=" + availableStartDate +
                ", availableEndDate=" + availableEndDate +
                ", roomType=" + roomType +
                '}';
    }
}
