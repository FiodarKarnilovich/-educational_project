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
                             JOIN auto a ON o.auto_id = a.id
                             JOIN autoModel am on am.id = a.modelName_id
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
                    Order order = toOrder(resultSet);
                    orders.add(order);
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

    private Order toOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();

        order.setId(resultSet.getInt("id"));
        order.setAutoBrand(resultSet.getString("brandName"));
        order.setAutoModel(resultSet.getString("modelName"));
        order.setStartDate(resultSet.getDate("dateStart").toLocalDate());
        order.setFinishDate(resultSet.getDate("dateFinish").toLocalDate());

    return order;
    }
}
