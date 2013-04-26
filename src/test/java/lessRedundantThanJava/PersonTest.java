package lessRedundantThanJava;

import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

//  SBT-command: test-only lessRedundantThanJava.PersonTest
public class PersonTest {
    @Test
    public void testingGettersAndSetters() {
    	
    	// Note that the goal here is not to minimize duplication (e.g. string literals) 
    	// but rather to illustrate that Java and Scala can implement the same interface (with less code for the Scala class)   
    	
        verifyGettersAndSetters(new PersonImplementedWithJava("Tomas", 37, "SWEDEN"));
        verifyGettersAndSetters(new PersonImplementedWithScala("Tomas", 37, "SWEDEN"));

        verifyGettersAndSetters(new PersonImplementedWithJava("Tomas", 37));
        verifyGettersAndSetters(new PersonImplementedWithScala("Tomas", 37));
    }

    private void verifyGettersAndSetters(final Person person) {
        assertEquals("Tomas", person.getName());
        assertEquals(37, person.getAge());
        assertEquals("SWEDEN", person.getCountryOfBirth());

        person.setName("Tom");
        person.setAge(38);
        person.setCountryOfBirth("USA");
        assertEquals("Tom", person.getName());
        assertEquals(38, person.getAge());
        assertEquals("USA", person.getCountryOfBirth());
    }
}