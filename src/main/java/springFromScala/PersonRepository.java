package springFromScala;

import java.util.Collection;

public interface PersonRepository { // Java interface
    Collection<Person> findAll(); // Person is a Scala class (see further down)
}