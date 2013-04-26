package springFromScala;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public final class PersonRepositoryImplementedWithJava implements PersonRepository {
    private final JdbcTemplate jdbcTemplate;
    public PersonRepositoryImplementedWithJava(final String connectionString) {
        jdbcTemplate = new JdbcTemplate(new DriverManagerDataSource(connectionString));
    }
    public Collection<Person> findAll() {
        final List<Person> persons = new ArrayList<Person>();
        jdbcTemplate.query(
            "select Name,Age from persons",
            new RowCallbackHandler() {
                public void processRow(ResultSet rs) throws SQLException {
                    persons.add(new Person(rs.getString("Name"), rs.getInt("Age")));
                }
            }
        );
        return Collections.unmodifiableCollection(persons);
    }
}
