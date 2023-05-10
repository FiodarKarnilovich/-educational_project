package by.karnilovich.service.order;

import by.karnilovich.db.dao.AutoDao;
import by.karnilovich.db.dao.AutoDaoImpl;
import by.karnilovich.db.dao.OrderDao;
import by.karnilovich.db.dao.OrderDaoImpl;
import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.order.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    private static OrderDao orderDao = new OrderDaoImpl();
    private static List<Order> orderList = new ArrayList<>();

    @Override
    public List<Order> getAllOrder() throws SQLException {
        return orderDao.getAll();
    }

    @Override
    public Auto getAutoFromOrderById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Order> getAllOrderByAutoId(int id) throws SQLException {
        try {
            return
                    orderDao.getAll().stream()
                            .filter(p -> p.getAuto_id() == id)
                            .collect(Collectors.toList());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
