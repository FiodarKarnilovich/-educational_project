package by.karnilovich.service.auto;

import by.karnilovich.db.dao.AutoDao;
import by.karnilovich.db.dao.AutoDaoImpl;
import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.order.Order;
import by.karnilovich.service.order.OrderService;
import by.karnilovich.service.order.OrderServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoServiceImpl implements IAutoService {

    private AutoDao autoDao = new AutoDaoImpl();

    //    1
    public AutoServiceImpl() {
    }

    public AutoServiceImpl(AutoDao autoDao) {
        this.autoDao = autoDao;
    }
    // 2
//    public void setAutoDao(AutoDao autoDao) {
//        this.autoDao = autoDao;
//    }

// 3
//    public AutoDao getAutoDao() {
//        return autoDao;
//    }

    @Override
    public List<Auto> availableCars(LocalDate start, LocalDate end) {
        try {
            return autoDao.getAll()
                    .stream()
                    .filter(auto -> {
                        try {
                            return checkAvailability(auto, start, end);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkAvailability(Auto auto, LocalDate start, LocalDate end) throws SQLException {

        List<Order> listOrderByAutoId = new ArrayList();
        int check = 0;
        if (listOrderByAutoId == null) {
            return true;
        } else {

            for (Order order : listOrderByAutoId) {

                // проверка даты, когда обе даты слева от брони или справа от брони
                if ((start.isBefore(order.getStartDate()) && (end.isBefore(order.getFinishDate()) || end.isEqual(order.getFinishDate())))
                        || ((start.isAfter(order.getStartDate()) || start.isEqual(order.getStartDate())) && end.isAfter(order.getFinishDate()))) {
                    check = 0;
                }
                // проверка даты, когда дата старта внутри ордера
                else if ((start.isAfter(order.getStartDate()) || start.isEqual(order.getStartDate())) && start.isBefore(order.getFinishDate()) && end.isAfter(order.getFinishDate())) {
                    check++;
                }
                // проверка даты, когда дата финиша внутри ордера
                else if (start.isBefore(order.getStartDate()) && (end.isAfter(order.getStartDate()) && (end.isBefore(order.getFinishDate()) || end.isEqual(order.getFinishDate())))) {
                    check++;
                }
                // проверка даты, когда заказ внутри ордера
                else if ((start.isAfter(order.getStartDate()) || start.isEqual(order.getStartDate())) && (end.isBefore(order.getFinishDate()) || end.isEqual(order.getFinishDate()))) {
                    check++;
                }
                // проверка даты, когда ордер внутри заказа
                else if (start.isBefore(order.getStartDate()) && end.isAfter(order.getFinishDate())) {
                    check++;
                }
            }

            if (check == 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
