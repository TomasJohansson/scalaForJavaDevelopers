package springFromScala;

import reflect.BeanProperty

class Person(@BeanProperty val name: String, @BeanProperty val age: Int) {
  override def toString: String = {
    return "Name: " + name + " , Age: " + age 
  }  
}