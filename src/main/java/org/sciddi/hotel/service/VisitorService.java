package org.sciddi.hotel.service;

import org.sciddi.hotel.dao.VisitorDAO;
import org.sciddi.hotel.model.Room;
import org.sciddi.hotel.model.Visitor;

import java.time.LocalDate;
import java.util.List;

public class VisitorService {
    private final VisitorDAO visitorDAO = new VisitorDAO();
    private RoomService roomService = new RoomService();

    public void addVisitor(Visitor visitor, int roomId) {
        Room room = roomService.getRoom(roomId);
        if (room == null) {
            throw new IllegalArgumentException("Room not found for ID: " + roomId);
        }

        // Check if visitor dates are within room's available date range
        if (!isDateWithinRange(visitor.getCheckInDate(), visitor.getCheckOutDate(),
                room.getAvailableStartDate(), room.getAvailableEndDate())) {
            throw new IllegalArgumentException("Visitor's dates do not align with room availability.");
        }

        visitor.setRoom(room);
        visitorDAO.add(visitor);
    }

    private boolean isDateWithinRange(LocalDate checkIn, LocalDate checkOut, LocalDate availableStart, LocalDate availableEnd) {
        return !checkIn.isBefore(availableStart) && !checkOut.isAfter(availableEnd);
    }

    public void deleteVisitor(int id) {
        visitorDAO.delete(id);
    }

    public void updateVisitor(Visitor visitor, int roomId) {
        deleteVisitor(visitor.getId());
        addVisitor(visitor, roomId); // Update checks date alignment again
    }

    public Visitor getVisitor(int id) {
        return visitorDAO.get(id);
    }

    public List<Visitor> getAllVisitors() {
        return visitorDAO.getAll();
    }


    public void setRoomService(RoomService service) {
        roomService = service;
    }
}
