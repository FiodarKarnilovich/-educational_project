package by.karnilovich.service.auto;

import by.karnilovich.entity.auto.Auto;

import java.util.ArrayList;
import java.util.List;

public class AutoService {

    private static List<Auto> autoList = new ArrayList<>();

    public static List<Auto> getAutoList() {
        return autoList;
    }

    public static List<Auto> addAutoToList(Auto auto) {
        autoList.add(auto);
        return autoList;
    }

}
