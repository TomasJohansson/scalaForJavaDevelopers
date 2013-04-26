package functionAsParameter

final class ScalaListMapperSimilarToJavaImplementationWithStrategies extends ListMapper {
  
  final def getUpperCasedStrings(stringsToBeReturnedUpperCased: java.util.List[String]): java.util.List[String] = {
    getMappedList(stringsToBeReturnedUpperCased, (s : String) => s.toUpperCase)
  }

  final def getLowerCasedStrings(stringsToBeReturnedLowerCased: java.util.List[String]): java.util.List[String] = {
    getMappedList(stringsToBeReturnedLowerCased, (s : String) => s.toLowerCase)
  }

  final def getLengthsOfStrings(stringsWithLengthsToBeReturned: java.util.List[java.lang.String]): java.util.List[Integer] = {
    getMappedList(stringsWithLengthsToBeReturned, (s : String) => s.length)
  }

  final def getWithEachElementMultiplied(
    integersToBeMultiplied: java.util.List[Integer],
    factorToMultiplyEachElementWith: Int
  ) : java.util.List[Integer] = {
    getMappedList(integersToBeMultiplied, (i : Integer) => (i.intValue * factorToMultiplyEachElementWith): Integer )
  }

  private def getMappedList[T,U](
    elementsToBeMapped: java.util.List[T],
    elementMappingStrategy: (T => U)
  ): java.util.List[U] = {
    val returnedElements = new java.util.ArrayList[U]
    val iterator = elementsToBeMapped.iterator
    while(iterator.hasNext) {
      returnedElements.add(elementMappingStrategy(iterator.next))
    }
    return returnedElements
  }

}