package org.sciddi.hotel.dao;

import org.sciddi.hotel.model.RoomType;

public class RoomTypeDAO extends AbstractGenericDAO<RoomType, Integer> {
    @Override
    protected Integer getId(RoomType entity) {
        return entity.getId();
    }
}

