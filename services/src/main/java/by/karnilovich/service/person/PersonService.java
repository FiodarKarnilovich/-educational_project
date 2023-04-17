package by.karnilovich.service.person;

import by.karnilovich.entity.person.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    //TODO: перенести в базу данных
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

    public static Person findByEmail(String email) {

        return PersonService.getPersonList().stream()
                .filter(p -> p.getEmail().equalsIgnoreCase(email))
                .findFirst().orElse(null);
    }
}
