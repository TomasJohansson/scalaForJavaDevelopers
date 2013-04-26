package functionAsParameter

import java.util.Arrays

import scala.collection.JavaConverters._

final class ScalaListMapper extends ListMapper 
{

  final def getUpperCasedStrings(stringsToBeReturnedUpperCased: java.util.List[String]): java.util.List[String] = {
    val sequence: Seq[String] = stringsToBeReturnedUpperCased.asScala.map(_.toUpperCase)
    sequence.asJava
  }

  final def getLowerCasedStrings(stringsToBeReturnedLowerCased: java.util.List[String]): java.util.List[String] = {
    val sequence = stringsToBeReturnedLowerCased.asScala.map(_.toLowerCase)
    sequence.asJava
  }


  final def getLengthsOfStrings(stringsWithLengthsToBeReturned: java.util.List[java.lang.String]): java.util.List[Integer] = {
    val scalaSequence = stringsWithLengthsToBeReturned.asScala.map(_.length)
    asJava(scalaSequence)
  }

  final def getWithEachElementMultiplied(
    integersToBeMultiplied: java.util.List[Integer],
    factorToMultiplyEachElementWith: Int
  ) : java.util.List[Integer] = {
    val products = integersToBeMultiplied.asScala.map( _.intValue * factorToMultiplyEachElementWith )
    asJava(products)
  }

  private final def asJava(listOfIntegers: Seq[Int]): java.util.List[Integer] = {
    val javaList = new java.util.ArrayList[Integer]
    listOfIntegers.foreach(myInt => javaList.add(myInt) )
    javaList
  }

}