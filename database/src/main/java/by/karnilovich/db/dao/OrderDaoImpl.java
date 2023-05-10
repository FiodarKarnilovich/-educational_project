package by.karnilovich.db.dao;

import by.karnilovich.db.connection.ConnectionManager;
import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.order.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao{

    public static final String GET_ALL_FROM_ORDER =
            """
                    SELECT o.*, am.modelName, ab.brandName 
                    FROM carOrder o
                    JOIN autoModel am ON a.modelName_id = am.id
                    JOIN autoBrand ab ON am.brandName_id = ab.id;
                    """;


    @Override
    public Order get(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Order> getAll() throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            List<Order> orders = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery(GET_ALL_FROM_ORDER)) {
                while (resultSet.next()) {
                    Auto auto = toOrder(resultSet);
                    orderss.add(order);
                }
            }
            return orders;
        }
    }

    @Override
    public Order save(Order order) throws SQLException {
        return null;
    }

    @Override
    public void update(Order order) throws SQLException {

    }

    @Override
    public void delete(Integer id) throws SQLException {

    }
}
