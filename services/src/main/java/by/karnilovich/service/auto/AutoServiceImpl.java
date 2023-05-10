package by.karnilovich.service.auto;

import by.karnilovich.db.dao.AutoDao;
import by.karnilovich.db.dao.AutoDaoImpl;
import by.karnilovich.entity.auto.Auto;

import java.sql.SQLException;
import java.time.LocalDate;
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
                    .filter(auto -> checkAvailability(auto, start, end))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkAvailability(Auto auto, LocalDate start, LocalDate end) {



        return true;
    }
}
