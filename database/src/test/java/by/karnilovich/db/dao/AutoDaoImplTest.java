package by.karnilovich.db.dao;

import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.person.Person;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AutoDaoImplTest {

    private AutoDao autoDao = new AutoDaoImpl();

    @Test
    @Order(1)
    void get() throws SQLException {
        Auto auto = autoDao.get(1);
        assertEquals(1, auto.getId());
        assertEquals(2022, auto.getYearAuto());
    }

    @Order(2)
    @Test
    void getAll() throws SQLException {
        final List<Auto> all = autoDao.getAll();
        assertEquals(5, all.size());
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}