package by.karnilovich.web.util;

import by.karnilovich.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {

    private static List<Person> personList = new ArrayList<>(){
        {
            add(new Person("ADMIN", "ADMIN", "admin@admin.com","admin", "16-03-1979", "375291000000", "ROLE_ADMIN"));
            add(new Person("User", "User", "user@user.com","user", "06-11-2000", "375291111111", "ROLE_USER"));

        }
    };

    public static List<Person> getPersonList() {
        return personList;
    }

    public static List<Person> addPersonToList(Person person) {
        personList.add(person);
        return personList;
    }
}
