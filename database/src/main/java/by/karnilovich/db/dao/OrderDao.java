package by.karnilovich.db.dao;

import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.order.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {

    Order get(Integer id) throws SQLException;

    List<Order> getAll() throws SQLException;

    Order save(Order order) throws SQLException;

    void update(Order order) throws SQLException;

    void delete(Integer id) throws SQLException;
}
