package observerTrait;

import java.util.Observable;

public class ObservableReusable extends Observable 
{
	@Override
	public void notifyObservers(Object arg) {
	    setChanged(); 
	    super.notifyObservers(arg);
	}
}
