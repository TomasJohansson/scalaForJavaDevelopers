package observerTrait;

import java.util.Observable;
import java.util.Observer;

public class ProductImplementedInJava extends ProductBaseClassWithImplementationIrrelevantForTheExample implements Product {
    private final Observable observable = new ObservableReusable();

    public void addObserver(Observer observer) {
        observable.addObserver(observer);
    }

    private Double price = null;
    public void setPrice(Double price) {
        this.price = price;
        observable.notifyObservers("(Java implementation) Product price changed. New price: " + price);
    }
}
