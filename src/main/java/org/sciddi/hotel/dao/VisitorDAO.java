package org.sciddi.hotel.dao;

import org.sciddi.hotel.model.Visitor;

public class VisitorDAO extends AbstractGenericDAO<Visitor, Integer> {
    @Override
    protected Integer getId(Visitor entity) {
        return entity.getId();
    }
}
