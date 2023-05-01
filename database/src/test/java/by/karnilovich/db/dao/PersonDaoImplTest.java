package by.karnilovich.db.dao;

import by.karnilovich.entity.person.Person;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.MethodOrderer.*;

@TestMethodOrder(OrderAnnotation.class)
class PersonDaoImplTest {

    private PersonDao personDao = new PersonDaoImpl();

    @Test
    @Order(1)
    void get() throws SQLException {
        Person person = personDao.get(1);
        assertEquals(1, person.getId());
        assertEquals("admin@admin.com", person.getEmail());
    }

    @Test
    @Order(2)
    void getAll() throws SQLException {
        final List<Person> all = personDao.getAll();
        assertEquals(3, all.size());

    }

    @Test
    @Order(3)
    void save() throws SQLException {
        final int size = personDao.getAll().size();

        Person person = new Person();
        person.setFirstName("test");
        person.setLastName("test");
        person.setEmail("test@test.com");
        person.setPassword("test");
        person.setBirthDay(LocalDate.of(1000, 01, 01));
        person.setPhoneNumber("00000000");
        person.setRole("2");
        personDao.save(person);

        assertEquals(size + 1, personDao.getAll().size());

    }

    @Test
    @Order(4)
    void update() throws SQLException {
        final List<Person> all = personDao.getAll();
        final int id = all.stream()
                .filter(p -> p.getEmail().equals("test@test.com"))
                .map(Person::getId)
                .findAny()
                .get();

        Person person = new Person();
        person.setId(id);
        person.setFirstName("test_upd");
        person.setLastName("test_upd");
        person.setEmail("test_upd@test.com");
        person.setPassword("test_upd");
        person.setBirthDay(LocalDate.of(1000, 01, 02));
        person.setPhoneNumber("0000000upd");
//        person.setRole("2");
        personDao.update(person);

        assertEquals(all.size(), personDao.getAll().size());
    }

    @Test
    @Order(5)
    void delete() throws SQLException {
        final List<Person> all = personDao.getAll();
        final int id = all.stream()
                .filter(p -> p.getEmail().equals("test_upd@test.com"))
                .map(Person::getId)
                .findAny()
                .get();

        personDao.delete(id);
        assertEquals(all.size() - 1, personDao.getAll().size());
    }
}