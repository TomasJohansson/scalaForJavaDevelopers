package observerTrait

class ProductImplementedInScala
  extends ProductBaseClassWithImplementationIrrelevantForTheExample
  with Product
  with ObservableTrait
{
  private var price: java.lang.Double = null
  def setPrice(price: java.lang.Double): Unit = {
    this.price = price
    notifyObservers("(Scala implementation) Product price changed. New price: " + price)
  }
}