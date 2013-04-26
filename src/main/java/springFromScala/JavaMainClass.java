package springFromScala;

import java.io.File;
import java.net.URL;

import org.relique.jdbc.csv.CsvDriver;

public final class JavaMainClass {

    private static void findPersonsAndPrintThemToConsole(final PersonRepository personRepository) {
        System.out.println("Finding some persons with the implementation class " + personRepository.getClass().getSimpleName());
        final Iterable<Person> persons = personRepository.findAll();
        for (Person person : persons) {
            // When you look in the Scala Person class above, it does not seem to have any getters methods,
            // but they are actually provided, thanks to the '@BeanProperty'
            // in the primary constructor (i.e. at the class declaration)
            printToConsole(person.toString() + " , " + person.getName() + " is " + person.getAge() + " years old");
        }
    }

    public static void main(String[] args) {
        printSomeHyphensToConsole();

        findPersonsAndPrintThemToConsole(new PersonRepositoryImplementedWithJava(getConnectionString()));

        printSomeHyphensToConsole();

        findPersonsAndPrintThemToConsole(new PersonRepositoryImplementedWithScala(getConnectionString()));

        printSomeHyphensToConsole();
    }

    private static void printSomeHyphensToConsole() {
        printToConsole("-----------------------------");
    }    
    private static void printToConsole(final String outputString) {
        System.out.println(outputString);
    }

    private static String connectionString = null;
    private static String getConnectionString() {
        if(connectionString == null) {
            try {
                Class.forName(CsvDriver.class.getName());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            connectionString = "jdbc:relique:csv:" + getPathToDirectoryWithCsvFile();
        }
        return connectionString;
    }

    // the below method below is "new" i.e. is/was not used in web page 'http://www.oo-systemutvecklare.se/scala-for-java-developers/scala-java-spring-interoperability-example/'
    // which instead hardcoded the path to "c:/temp/txtFilesFolder" 
	private static String getPathToDirectoryWithCsvFile() {
        URL urlForPersonsFile = JavaMainClass.class.getResource("/persons.csv");
        //System.out.println(urlForPersonsFile.getPath()); // when using Windows, this path is something like '/C:/code/scala/workspaceForScalaForJavaDevelopers/scalaForJavaDevelopers/bin/persons.csv' i.e. with a leading slash, but it still works as constructor parameter to the below File class
        File personsFile = new File(urlForPersonsFile.getPath());
        String pathToDirectory = personsFile.getParentFile().getAbsolutePath();
        return pathToDirectory;
	}
   
}