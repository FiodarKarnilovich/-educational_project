package by.karnilovich.db.dao;

import by.karnilovich.db.connection.ConnectionManager;
import by.karnilovich.entity.person.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    public static final String SELECT_FROM_PERSON =
            """
                    SELECT p.*, r.roleName 
                    FROM person p 
                    JOIN userRole r ON p.userRole_id = r.id;
                    """;
    public static final String INSERT_INTO =
            """
                    INSERT INTO person (firstName, lastName, email, password, birthDay, phoneNumber, userRole_id)
                    VALUES (?,?,?,?,?,?,2);
                    """;

    @Override
    public Person get(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Person> getAll() throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            List<Person> persons = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery(SELECT_FROM_PERSON)) {
                while (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt("id"));
                    person.setFirstName(resultSet.getString("firstName"));
                    person.setLastName(resultSet.getString("lastName"));
                    person.setEmail(resultSet.getString("email"));
                    person.setPassword(resultSet.getString("password"));
                    person.setBirthDay(resultSet.getDate("birthDay").toLocalDate());
                    person.setPhoneNumber(resultSet.getString("phoneNumber"));
                    person.setRole(resultSet.getString("roleName"));
                    persons.add(person);
                }
            }
            return persons;
        }
    }

    @Override
    public Person save(Person person) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setString(4, person.getPassword());
            preparedStatement.setDate(5, Date.valueOf(person.getBirthDay()));
            preparedStatement.setString(6, person.getPhoneNumber());

            preparedStatement.executeUpdate();
        }
        return getAll().stream()
                .filter(p -> p.getEmail().equals(person.getEmail()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Person person) throws SQLException {

    }

    @Override
    public int delete(Integer id) throws SQLException {
        return 0;
    }
}
