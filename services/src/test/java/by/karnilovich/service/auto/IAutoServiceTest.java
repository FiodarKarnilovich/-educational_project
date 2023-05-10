package by.karnilovich.service.auto;

import by.karnilovich.db.dao.AutoDao;
import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.order.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
    void checkAvailability() {
        // case when startDate in another order
        Order order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 3));
        order.setFinishDate(LocalDate.of(2023, 5, 6));
        Auto auto = new Auto();
        auto.addOrder(order);
        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when startDate in another order");

        // case when endDate in another order
        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 6));
        order.setFinishDate(LocalDate.of(2023, 5, 12));
        auto = new Auto();
        auto.addOrder(order);
        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when endDate in another order");

        // case when both startDate and endDate in another order
        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 6));
        order.setFinishDate(LocalDate.of(2023, 5, 7));
        auto = new Auto();
        auto.addOrder(order);
        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when both startDate and endDate in another order");

        // case when new order inside another order
        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 6));
        order.setFinishDate(LocalDate.of(2023, 5, 7));
        auto = new Auto();
        auto.addOrder(order);
        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when new order inside another order");

        // case ok 1
        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 2));
        order.setFinishDate(LocalDate.of(2023, 5, 3));
        auto = new Auto();
        auto.addOrder(order);
        assertTrue(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "ok");

        // case ok 2
        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 11));
        order.setFinishDate(LocalDate.of(2023, 5, 15));
        auto = new Auto();
        auto.addOrder(order);
        assertTrue(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "ok 2");


    }

    @Test
    void checkAvailabilityWhenLeftBorder() {
        Order order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 2));
        order.setFinishDate(LocalDate.of(2023, 5, 5));
        Auto auto = new Auto();
        auto.addOrder(order);
        assertTrue(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "ok 3");
    }

    @Test
    void checkAvailabilityMultipleOrdersFalse() {
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