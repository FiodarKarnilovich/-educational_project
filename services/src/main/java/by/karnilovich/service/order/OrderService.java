package by.karnilovich.service.order;

import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.order.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    public List<Order> getAllOrder() throws SQLException;

    public Auto getAutoFromOrderById(int id) throws SQLException;

    public List<Order> getAllOrderByAutoId(int id) throws SQLException;
}
