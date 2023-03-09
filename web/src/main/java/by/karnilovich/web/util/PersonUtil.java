package by.karnilovich.web.util;

import by.karnilovich.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {

    private static List<Person> personList = new ArrayList<>(){
        {
            add(new Person("admin@admin.com","admin"));
            add(new Person("user@user.com","user"));
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
