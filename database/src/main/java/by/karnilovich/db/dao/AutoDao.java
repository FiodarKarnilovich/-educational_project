package by.karnilovich.db.dao;

import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.auto.Brand;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AutoDao {
    Auto get(Integer id) throws SQLException;

    List<Auto> getAll() throws SQLException;

    Auto save(Auto auto) throws SQLException;

    void update(Auto auto) throws SQLException;

    void delete(Integer id) throws SQLException;

    void createAutoBrandIfNotFound(String autoBrand) throws SQLException;

    Optional<String> findAutoBrandByName(String autoBrand) throws SQLException;

    Optional<Brand> getBrandByNameOrCreateIfNotExist(String autoBrand) throws SQLException;
}
