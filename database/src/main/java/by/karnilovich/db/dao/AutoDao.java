package by.karnilovich.db.dao;

import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.person.Person;

import java.sql.SQLException;
import java.util.List;

public interface AutoDao {
    Auto get(Integer id) throws SQLException;

    List<Auto> getAll() throws SQLException;

    Auto save(Person person) throws SQLException;

    void update(Auto auto) throws SQLException;

    void delete(Integer id) throws SQLException;
}
