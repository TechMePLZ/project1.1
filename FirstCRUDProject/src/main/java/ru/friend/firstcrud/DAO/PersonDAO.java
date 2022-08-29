package ru.friend.firstcrud.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.friend.firstcrud.models.Book;
import ru.friend.firstcrud.models.Person;
import ru.friend.firstcrud.util.PersonValidator;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> index() {

        return jdbcTemplate.query("SELECT * FROM PERSON", new BeanPropertyRowMapper<>(Person.class));
    }

    public Optional<Person> show(String name) {
        return jdbcTemplate.query("SELECT * FROM PERSON WHERE name = ?", new Object[]{name},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM PERSON WHERE person_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO PERSON (name, year_of_birth) VALUES (?,?)", person.getName(),
                person.getYear_of_birth());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM PERSON WHERE person_id =?", id);
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE PERSON SET name = ?, year_of_birth = ? WHERE person_id = ? ", updatedPerson.getName(),
                updatedPerson.getYear_of_birth(), id);
    }

    public Object getBooksByPersonID(int id) {
        return jdbcTemplate.query("SELECT * FROM BOOK WHERE user_id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }
}
