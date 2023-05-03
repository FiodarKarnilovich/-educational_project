package by.karnilovich.service.auto;

import by.karnilovich.db.dao.AutoDao;
import by.karnilovich.db.dao.AutoDaoImpl;
import by.karnilovich.entity.auto.Auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutoService {


    private static AutoDao autoDao = new AutoDaoImpl();
    private static List<Auto> autoList = new ArrayList<>();

    public static List<Auto> getAutoList() throws Exception{

        return autoDao.getAll();
    }

    public static List<Auto> addAutoToList(Auto auto) throws SQLException {
        autoDao.save(auto);
        return autoDao.getAll();
    }

    public void createAutoBrand(String autoBrand) throws SQLException {

    }

}
