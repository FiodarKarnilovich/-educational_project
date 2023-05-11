package by.karnilovich.service.auto;

import by.karnilovich.db.dao.AutoDao;
import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.order.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IAutoServiceTest {

    private static AutoDao autoDao = Mockito.mock(AutoDao.class);

    private IAutoService autoService = new AutoServiceImpl(autoDao);

    @BeforeAll
    public static void before() throws Exception {
        Order order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 3));
        order.setFinishDate(LocalDate.of(2023, 5, 6));
        Auto auto1 = new Auto();
        auto1.addOrder(order);

        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 6));
        order.setFinishDate(LocalDate.of(2023, 5, 12));
        Auto auto2 = new Auto();
        auto2.addOrder(order);

        Auto auto3 = new Auto();
        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 2));
        order.setFinishDate(LocalDate.of(2023, 5, 3));
        auto3.addOrder(order);

        List<Auto> autos = List.of(auto1, auto2, auto3);
        Mockito.when(autoDao.getAll()).thenReturn(autos);
    }

    @Test
    void availableCars() throws Exception {
        List<Auto> autos = autoService.availableCars(
                LocalDate.of(2023, 5, 5),
                LocalDate.of(2023, 5, 8));

        assertEquals(1, autos.size());
    }

    @Test
    void checkAvailabilityWhenStartDateInAnotherOrder() throws SQLException {
        // case when startDate in another order
        Order order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 3));
        order.setFinishDate(LocalDate.of(2023, 5, 6));
        Auto auto = new Auto();
        auto.addOrder(order);
        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when startDate in another order");
    }

    @Test
    void checkAvailabilityWhenEndDateInAnotherOrder() throws SQLException {
        // case when endDate in another order
        Order order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 6));
        order.setFinishDate(LocalDate.of(2023, 5, 12));
        Auto auto = new Auto();
        auto.addOrder(order);
        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when endDate in another order");
    }

    @Test
    void checkAvailabilityWhenBothStartDateAndEndDateInAnotherOrder() throws SQLException {
        // case when both startDate and endDate in another order
        Order order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 6));
        order.setFinishDate(LocalDate.of(2023, 5, 7));
        Auto auto = new Auto();
        auto.addOrder(order);
        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when both startDate and endDate in another order");
    }

    @Test
    void checkAvailabilityWhenNewOrderInsideAnotherOrder() throws SQLException {
        // case when new order inside another order
        Order order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 6));
        order.setFinishDate(LocalDate.of(2023, 5, 7));
        Auto auto = new Auto();
        auto.addOrder(order);
        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when new order inside another order");

    }

    @Test
    void checkAvailabilityWhenOk1() throws SQLException {
        // case ok 1
        Order order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 2));
        order.setFinishDate(LocalDate.of(2023, 5, 3));
        Auto auto = new Auto();
        auto.addOrder(order);
        assertTrue(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "ok");
    }

    @Test
    void checkAvailabilityWhenOk2() throws SQLException {
        // case ok 2
        Order order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 11));
        order.setFinishDate(LocalDate.of(2023, 5, 15));
        Auto auto = new Auto();
        auto.addOrder(order);
        assertTrue(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "ok 2");
    }

    @Test
    void checkAvailabilityWhenLeftBorder() throws SQLException {
        Order order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 2));
        order.setFinishDate(LocalDate.of(2023, 5, 5));
        Auto auto = new Auto();
        auto.addOrder(order);
        assertTrue(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "ok 3");
    }

    @Test
    void checkAvailabilityMultipleOrdersFalse() throws SQLException {
        // case when startDate in another order
        Auto auto = new Auto();
        Order order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 3));
        order.setFinishDate(LocalDate.of(2023, 5, 6));
        auto.addOrder(order);

        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 2));
        order.setFinishDate(LocalDate.of(2023, 5, 3));
        auto.addOrder(order);

        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when startDate in another order");

    }
}