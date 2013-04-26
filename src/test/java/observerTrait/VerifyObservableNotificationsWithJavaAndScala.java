package observerTrait;

import org.junit.Test;
import org.mockito.Matchers;
import java.util.Observable;
import java.util.Observer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.contains;

//  SBT-command: test-only observerTrait.VerifyObservableNotificationsWithJavaAndScala
public class VerifyObservableNotificationsWithJavaAndScala {

    private final static Observer observerOutputtingToTheConsole = new ConsoleView();

    @Test
    public void verifyObservableNotifications() {
        verifyObservableNotificationForPersonWhenNameChanges(new PersonImplementedInJava());
        verifyObservableNotificationForPersonWhenNameChanges(new PersonImplementedInScala());

        verifyObservableNotificationForProductWhenPriceChanges(new ProductImplementedInJava());
        verifyObservableNotificationForProductWhenPriceChanges(new ProductImplementedInScala());
    }

    private void verifyObservableNotificationForPersonWhenNameChanges(final Person person) {
        final Observer observer = mock(Observer.class);

        person.addObserver(observerOutputtingToTheConsole);
        person.addObserver(observer);

        person.setName("Tomas");

         verify(
             observer,
             times(1)
         ).update(Matchers.any(Observable.class), contains("Tomas"));
    }    

    private void verifyObservableNotificationForProductWhenPriceChanges(final Product product) {
        final Observer observer = mock(Observer.class);

        product.addObserver(observerOutputtingToTheConsole);
        product.addObserver(observer);
        
        product.setPrice(123.45);

         verify(
             observer,
             times(1)
         ).update(Matchers.any(Observable.class), contains("123.45"));
    }

}