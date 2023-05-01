package by.karnilovich.db.dao;

import by.karnilovich.db.connection.ConnectionManager;
import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.person.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AutoDaoImpl implements AutoDao{

    public static final String GET_ALL_FROM_AUTO =
            """
                    SELECT a.*, am.modelName, ab.brandName 
                    FROM auto a
                    JOIN autoModel am ON a.modelName_id = am.id
                    JOIN autoBrand ab ON am.brandName_id = ab.id;
                    """;

    @Override
    public Auto get(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Auto> getAll() throws SQLException {

        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            List<Auto> autos = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery(GET_ALL_FROM_AUTO)) {
                while (resultSet.next()) {
                    Auto auto = new Auto();
                    auto.setId(resultSet.getInt("id"));
                    auto.setAutoBrand(resultSet.getString("brandName"));
                    auto.setAutoModel(resultSet.getString("modelName"));
                    auto.setColourAuto(resultSet.getString("colourAuto"));
                    auto.setTransmissionAuto(resultSet.getString("transmissionAuto"));
                    auto.setYearAuto(resultSet.getInt("yearAuto"));
                    auto.setPriceAuto(resultSet.getDouble("priceAuto"));
                    autos.add(auto);
                }
            }
            return autos;
        }
    }

    @Override
    public Auto save(Person person) throws SQLException {
        return null;
    }

    @Override
    public void update(Auto auto) throws SQLException {

    }

    @Override
    public void delete(Integer id) throws SQLException {

    }
}
