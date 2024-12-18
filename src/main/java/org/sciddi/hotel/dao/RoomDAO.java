package org.sciddi.hotel.dao;

import org.sciddi.hotel.model.Room;

public class RoomDAO extends AbstractGenericDAO<Room, Integer> {
    @Override
    protected Integer getId(Room entity) {
        return entity.getId();
    }
}

