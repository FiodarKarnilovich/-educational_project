package by.karnilovich.service.person;

import by.karnilovich.db.dao.PersonDao;
import by.karnilovich.db.dao.PersonDaoImpl;
import by.karnilovich.entity.person.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private PersonDao personDao = new PersonDaoImpl();


    public List<Person> getPersonList() throws Exception {
        return personDao.getAll();
    }

    public Person getPersonByEmail(String email) throws Exception {
        return null;
    }

    public List<Person> addPersonToList(Person person) throws SQLException {
        personDao.save(person);
        return personDao.getAll();
    }

    public Person findByEmail(String email) throws SQLException {

        return personDao.getAll().stream()
                .filter(p -> p.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }



}
