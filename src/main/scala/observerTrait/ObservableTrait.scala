package observerTrait

import java.util.{Observer, Observable}

trait ObservableTrait {

  private val observable = new ObservableReusable();

  def addObserver(observer: Observer): Unit = {
    observable.addObserver(observer)
  }

  protected def notifyObservers(observer: Object): Unit = {
    observable.notifyObservers(observer)
  }
}