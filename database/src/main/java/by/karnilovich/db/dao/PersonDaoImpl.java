package by.karnilovich.db.dao;

import by.karnilovich.db.connection.ConnectionManager;
import by.karnilovich.entity.person.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    public static final String GET_ALL_FROM_PERSON =
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

    public static final String DELETE_FROM_PERSON_BY_ID = """
            DELETE FROM person WHERE id =?;
           """;

    public static final String GET_FROM_PERSON_BY_ID = """
           SELECT p.* , r.roleName 
           FROM person AS p
           JOIN userRole r ON p.userRole_id = r.id
           WHERE p.id =?;
           """;

    public static final String UPDATE_PERSON_BY_ID = """
            UPDATE person
            SET firstName =?,
            lastName =?,
            email =?,
            password =?,
            birthDay =?,
            phoneNumber =?
            WHERE id =?;
            """;


    @Override
    public Person get(Integer id) throws SQLException {

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_FROM_PERSON_BY_ID)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return toPerson(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public List<Person> getAll() throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            List<Person> persons = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery(GET_ALL_FROM_PERSON)) {
                while (resultSet.next()) {
                    Person person = toPerson(resultSet);
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
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PERSON_BY_ID)) {

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setString(4, person.getPassword());
            preparedStatement.setDate(5, Date.valueOf(person.getBirthDay()));
            preparedStatement.setString(6, person.getPhoneNumber());
            preparedStatement.setInt(7, person.getId());

            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_PERSON_BY_ID)) {

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }
    }

    private Person toPerson(ResultSet resultSet) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setFirstName(resultSet.getString("firstName"));
        person.setLastName(resultSet.getString("lastName"));
        person.setEmail(resultSet.getString("email"));
        person.setPassword(resultSet.getString("password"));
        person.setBirthDay(resultSet.getDate("birthDay").toLocalDate());
        person.setPhoneNumber(resultSet.getString("phoneNumber"));
        person.setRole(resultSet.getString("roleName"));
        return person;
    }

}
