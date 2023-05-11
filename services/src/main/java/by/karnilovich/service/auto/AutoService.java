package by.karnilovich.service.auto;

import by.karnilovich.db.dao.AutoDao;
import by.karnilovich.db.dao.AutoDaoImpl;
import by.karnilovich.entity.auto.Auto;
import by.karnilovich.entity.order.Order;
import by.karnilovich.service.order.OrderService;
import by.karnilovich.service.order.OrderServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutoService {


    private static AutoDao autoDao = new AutoDaoImpl();
    private static List<Auto> autoList = new ArrayList<>();
    private OrderService orderService = new OrderServiceImpl();

    public static List<Auto> getAutoList() throws Exception{

        return autoDao.getAll();
    }

    public static List<Auto> addAutoToList(Auto auto) throws SQLException {
        autoDao.save(auto);
        return autoDao.getAll();
    }

    public void createAutoBrand(String autoBrand) throws SQLException {

    }

    public List<Auto> getAutoListWithOrders() throws Exception{
        List<Auto> allAutos = autoDao.getAll();
        for (Auto auto: allAutos) {
            List<Order> allOrdersByAutoId = orderService.getAllOrdersByAutoId(auto.getId());
            auto.setOrders(allOrdersByAutoId);

        }
        return allAutos;
    }

}
