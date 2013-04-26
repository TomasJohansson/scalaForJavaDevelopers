package observerTrait;

import java.util.Observable;
import java.util.Observer;

public class PersonImplementedInJava extends PersonBaseClassWithImplementationIrrelevantForTheExample implements Person {
    private final Observable observable = new ObservableReusable();

    public void addObserver(Observer observer) {
        observable.addObserver(observer);
    }

    private String name = "";

    /**
     * This method is defined in the interface Person
     */
    public void setName(String name) {
        this.name = name;
        observable.notifyObservers("(Java implementation) Person name changed. New name: " + name);
    }
}
