package springFromScala;

import java.sql.ResultSet

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowCallbackHandler
import org.springframework.jdbc.datasource.DriverManagerDataSource

class PersonRepositoryImplementedWithScala(connectionString: String) extends PersonRepository {
  val jdbcTemplate = new JdbcTemplate(new DriverManagerDataSource(connectionString))
  def findAll: java.util.Collection[Person] = {
    val persons = new java.util.ArrayList[Person]
    jdbcTemplate.query("select Name,Age from persons", new RowCallbackHandler {
      def processRow(rs: ResultSet) = {
        persons.add(new Person(rs.getString("Name"), rs.getInt("Age")))
      }
    })
    return persons
  }
}