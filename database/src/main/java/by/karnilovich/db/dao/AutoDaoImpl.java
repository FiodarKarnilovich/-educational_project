package by.karnilovich.db.dao;

import by.karnilovich.db.connection.ConnectionManager;
import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.person.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoDaoImpl implements AutoDao {

    public static final String GET_ALL_FROM_AUTO =
            """
                    SELECT a.*, am.modelName, ab.brandName 
                    FROM auto a
                    JOIN autoModel am ON a.modelName_id = am.id
                    JOIN autoBrand ab ON am.brandName_id = ab.id;
                    """;

    public static final String GET_FROM_AUTO_BY_ID = """
            SELECT a.*, am.modelName, ab.brandName 
            FROM auto a
            JOIN autoModel am ON a.modelName_id = am.id
            JOIN autoBrand ab ON am.brandName_id = ab.id
            WHERE a.id =?;
            """;

    public static final String INSERT_INTO =
            """
                    INSERT INTO auto (modelName_id, colourAuto, transmissionAuto, yearAuto, priceAuto)
//                    VALUES (?,?,?,?,?);
                    """;
    public static final String DELETE_FROM_AUTO_BY_ID = """
            DELETE FROM auto WHERE id =?;
            """;
    public static final String UPDATE_AUTO_BY_ID = """
            UPDATE auto
            SET priceAuto =?,
            WHERE id =?;
            """;

    @Override
    public Auto get(Integer id) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_FROM_AUTO_BY_ID)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return toAuto(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public List<Auto> getAll() throws SQLException {

        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            List<Auto> autos = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery(GET_ALL_FROM_AUTO)) {
                while (resultSet.next()) {
                    Auto auto = toAuto(resultSet);
                    autos.add(auto);
                }
            }
            return autos;
        }
    }

    @Override
    public Auto save(Auto auto) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, auto.getAutoModel());
            preparedStatement.setString(2, auto.getColourAuto());
            preparedStatement.setString(3, auto.getTransmissionAuto());
            preparedStatement.setInt(4, auto.getYearAuto());
            preparedStatement.setDouble(5, auto.getPriceAuto());

            preparedStatement.executeUpdate();
        }
        return getAll().stream()
                .filter(p -> p.getId() == auto.getId())
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Auto auto) throws SQLException {
            try (Connection connection = ConnectionManager.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AUTO_BY_ID)) {

                preparedStatement.setDouble(1, auto.getPriceAuto());
                preparedStatement.setInt(2, auto.getId());

                preparedStatement.executeUpdate();
            }

        }
    @Override
    public void delete(Integer id) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_AUTO_BY_ID)) {

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }
    }

    private Auto toAuto(ResultSet resultSet) throws SQLException {
        Auto auto = new Auto();
        auto.setId(resultSet.getInt("id"));
        auto.setAutoBrand(resultSet.getString("brandName"));
        auto.setAutoModel(resultSet.getString("modelName"));
        auto.setColourAuto(resultSet.getString("colourAuto"));
        auto.setTransmissionAuto(resultSet.getString("transmissionAuto"));
        auto.setYearAuto(resultSet.getInt("yearAuto"));
        auto.setPriceAuto(resultSet.getDouble("priceAuto"));

        return auto;
    }
}
