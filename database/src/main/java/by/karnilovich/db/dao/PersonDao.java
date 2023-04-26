package by.karnilovich.db.dao;

import by.karnilovich.entity.person.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {

    Person get(Integer id) throws SQLException;

    List<Person> getAll() throws SQLException;

    Person save(Person person) throws SQLException;

    void update(Person person) throws SQLException;

    void delete(Integer id) throws SQLException;
}
