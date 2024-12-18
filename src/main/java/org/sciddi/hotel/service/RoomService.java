package org.sciddi.hotel.service;

import org.sciddi.hotel.dao.RoomDAO;
import org.sciddi.hotel.model.Room;

import java.time.LocalDate;
import java.util.List;

public class RoomService {
    private final RoomDAO roomDAO = new RoomDAO();

    public void addRoom(Room room) {
        // Tarih aralığı çakışması kontrolü
        boolean isDateConflict = roomDAO.getAll().stream()
                .anyMatch(existingRoom -> existingRoom.getRoomType().getId() == room.getRoomType().getId() &&
                        existingRoom.getRoomNumber().equals(room.getRoomNumber()) &&
                        datesOverlap(existingRoom.getAvailableStartDate(), existingRoom.getAvailableEndDate(),
                                room.getAvailableStartDate(), room.getAvailableEndDate()));

        if (isDateConflict) {
            throw new IllegalArgumentException("Date conflict detected for room: " + room.getRoomNumber());
        }

        roomDAO.add(room);
    }

    private boolean datesOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return (start1.isBefore(end2) || start1.equals(end2)) &&
                (start2.isBefore(end1) || start2.equals(end1));
    }

    public void deleteRoom(int id) {
        roomDAO.delete(id);
    }

    public void updateRoom(Room room) {
        deleteRoom(room.getId());
        addRoom(room); // Güncellenen oda için tarih çakışması kontrolü
    }

    public Room getRoom(int id) {
        return roomDAO.get(id);
    }

    public List<Room> getAllRooms() {
        return roomDAO.getAll();
    }
}
