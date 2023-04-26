package by.karnilovich.service.person;

import by.karnilovich.db.dao.PersonDao;
import by.karnilovich.db.dao.PersonDaoImpl;
import by.karnilovich.entity.person.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private PersonDao personDao = new PersonDaoImpl();
    //TODO: перенести в базу данных
//    private static List<Person> personList = new ArrayList<>(){
//        {
//            add(new Person(1, "ADMIN", "ADMIN", "admin@admin.com","admin", "16-03-1979", "375291000000", "ROLE_ADMIN"));
//            add(new Person(2, "User", "User", "user@user.com","user", "06-11-2000", "375291111111", "ROLE_USER"));
//
//        }
//    };


    public List<Person> getPersonList() throws Exception {
        return personDao.getAll();
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
