package org.sciddi.hotel.service;

import org.sciddi.hotel.dao.RoomTypeDAO;
import org.sciddi.hotel.model.RoomType;

import java.util.List;

public class RoomTypeService {
    private final RoomTypeDAO roomTypeDAO = new RoomTypeDAO();

    public void addRoomType(RoomType roomType) {
        roomTypeDAO.add(roomType);
    }

    public void deleteRoomType(int id) {
        roomTypeDAO.delete(id);
    }

    public void updateRoomType(RoomType roomType) {
        roomTypeDAO.update(roomType);
    }

    public RoomType getRoomType(int id) {
        return roomTypeDAO.get(id);
    }

    public List<RoomType> getAllRoomTypes() {
        return roomTypeDAO.getAll();
    }
}

