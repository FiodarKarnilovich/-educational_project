package by.karnilovich.service.auto;

import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.order.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class IAutoServiceTest {

    private IAutoService autoService = new IAutoService() {

        @Override
        public List<Auto> availableCars(LocalDate start, LocalDate end) {
            List<Auto> result = new ArrayList<Auto>();
            return result.stream()
                    .filter(auto -> checkAvailability(auto, start, end))
                    .collect(Collectors.toList());
        }

        @Override
        public boolean checkAvailability(Auto auto, LocalDate start, LocalDate end) {
            return true;
        }
    };


    @Test
    void availableCars() {
    }

    @Test
    void checkAvailability() {
        // case when startDate in another order
        Order order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 3));
        order.setEndDate(LocalDate.of(2023, 5, 6));
        Auto auto = new Auto();
        auto.addOrder(order);
        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when startDate in another order");

        // case when endDate in another order
        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 6));
        order.setEndDate(LocalDate.of(2023, 5, 12));
        auto = new Auto();
        auto.addOrder(order);
        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when endDate in another order");

        // case when both startDate and endDate in another order
        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 6));
        order.setEndDate(LocalDate.of(2023, 5, 7));
        auto = new Auto();
        auto.addOrder(order);
        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when both startDate and endDate in another order");

        // case when new order inside another order
        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 6));
        order.setEndDate(LocalDate.of(2023, 5, 7));
        auto = new Auto();
        auto.addOrder(order);
        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when new order inside another order");

        // case ok 1
        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 2));
        order.setEndDate(LocalDate.of(2023, 5, 3));
        auto = new Auto();
        auto.addOrder(order);
        assertTrue(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "ok");

        // case ok 2
        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 11));
        order.setEndDate(LocalDate.of(2023, 5, 15));
        auto = new Auto();
        auto.addOrder(order);
        assertTrue(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "ok 2");


    }

    @Test
    void checkAvailabilityWhenLeftBorder() {
        Order order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 2));
        order.setEndDate(LocalDate.of(2023, 5, 5));
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
        order.setEndDate(LocalDate.of(2023, 5, 6));
        auto.addOrder(order);

        order = new Order();
        order.setStartDate(LocalDate.of(2023, 5, 2));
        order.setEndDate(LocalDate.of(2023, 5, 3));
        auto.addOrder(order);

        assertFalse(autoService.checkAvailability(auto, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 8)), "case when startDate in another order");

    }
}