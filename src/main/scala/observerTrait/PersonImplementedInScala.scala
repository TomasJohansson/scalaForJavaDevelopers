package observerTrait

class PersonImplementedInScala
  extends PersonBaseClassWithImplementationIrrelevantForTheExample  
  with Person
  with ObservableTrait
{
  private var name = "";
  def setName(name: String) = {
    this.name = name;
    notifyObservers("(Scala implementation) Person name changed. New name: " + name)
  }
}