package observerTrait;

import java.util.Observable;
import java.util.Observer;

public class ConsoleView implements Observer {
    public void update(Observable observable, Object arg) {
        System.out.println("ConsoleView Observer recieved update:" + arg);
    }
}