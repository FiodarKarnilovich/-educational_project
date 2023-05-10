package by.karnilovich.service.order;

import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.order.Order;

public interface OrderService {

    public Order getAllOrder();


    public Auto getAutoById(int id);
}
