package by.karnilovich.db.dao;

import by.karnilovich.entity.person.Person;

import java.sql.SQLException;
import java.util.List;

public class PersonDaoImpl implements PersonDao{

    @Override
    public Person get(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Person> getAll() throws SQLException {
        return null;
    }

    @Override
    public Person save(Person person) throws SQLException {
        return null;
    }

    @Override
    public void update(Person person) throws SQLException {

    }

    @Override
    public int delete(Integer id) throws SQLException {
        return 0;
    }
}
