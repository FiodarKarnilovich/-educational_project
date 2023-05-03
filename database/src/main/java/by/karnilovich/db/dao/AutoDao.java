package by.karnilovich.db.dao;

import by.karnilovich.entity.auto.Auto;

import java.sql.SQLException;
import java.util.List;

public interface AutoDao {
    Auto get(Integer id) throws SQLException;

    List<Auto> getAll() throws SQLException;

    Auto save(Auto auto) throws SQLException;

    void update(Auto auto) throws SQLException;

    void delete(Integer id) throws SQLException;

    void createAutoBrandIfNotFound(String autoBrand) throws SQLException;
}
