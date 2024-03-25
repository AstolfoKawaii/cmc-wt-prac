package dev.astolfo.books.dao;

import dev.astolfo.books.entities.Order;
import org.hibernate.SessionFactory;

public class OrderDao extends GenericDao<Order> {
    public OrderDao(SessionFactory builder) {
        super(builder, Order.class);
    }
}
