package lessRedundantThanJava

import reflect.BeanProperty

class PersonImplementedWithScala(
  @BeanProperty var name: String,
  @BeanProperty var age: Int,
  @BeanProperty var countryOfBirth: String
)
	extends Person 
{
    def this(name: String, age: Int) = this(name, age, "SWEDEN")
}