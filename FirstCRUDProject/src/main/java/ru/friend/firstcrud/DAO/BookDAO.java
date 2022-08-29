package ru.friend.firstcrud.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.friend.firstcrud.models.Book;
import ru.friend.firstcrud.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {

        return jdbcTemplate.query("SELECT * FROM book ", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE book_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book ( name, author, yearofproduction) VALUES (?,?,?)", book.getName(),
                book.getAuthor(), book.getYearOfProduction());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE book_id=?", id);
    }

    public void connect(int id, Person person) {
        jdbcTemplate.update("UPDATE book SET user_id=? WHERE book_id=?", person.getPerson_id(), id);
    }

    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("SELECT Person. * FROM book JOIN person ON book.user_id=person.person_id WHERE Book.book_id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }


    public void release(int id) {
        jdbcTemplate.update("UPDATE book SET user_id=null WHERE book_id=?", id);
    }
}
