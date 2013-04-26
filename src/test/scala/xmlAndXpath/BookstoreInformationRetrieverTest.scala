package xmlAndXpath

import org.junit.Assert.assertEquals
import org.junit.Test
import xml.PrettyPrinter

//  SBT-command: test-only xmlAndXpath.BookstoreInformationRetrieverTest
class BookstoreInformationRetrieverTest {

  private val bookstoreXml: scala.xml.Elem =

    <bookstore>

      <book category="COOKING">
        <title lang="en">Everyday Italian</title>
        <author>Giada De Laurentiis</author>
        <year>2005</year>
        <price>30.00</price>
      </book>

      <book category="CHILDREN">
        <title lang="en">Harry Potter</title>
        <author>J K. Rowling</author>
        <year>2005</year>
        <price>29.99</price>
      </book>

      <book category="WEB">
        <title lang="en">XQuery Kick Start</title>
        <author>James McGovern</author>
        <author>Per Bothner</author>
        <author>Kurt Cagle</author>
        <author>James Linn</author>
        <author>Vaidyanathan Nagarajan</author>
        <year>2003</year>
        <price>49.99</price>
      </book>

      <book category="WEB">
        <title lang="en">Learning XML</title>
        <author>Erik T. Ray</author>
        <year>2003</year>
        <price>39.95</price>
      </book>

    </bookstore>

  @Test
  def verifyThatBookTitlesCanBeRetrievedFromBookstoreXml() {
    verifyThatBookTitlesCanBeRetrievedFromBookstoreXml(new BookstoreInformationRetrieverImplementedWithNativeScala)
    verifyThatBookTitlesCanBeRetrievedFromBookstoreXml(new BookstoreInformationRetrieverImplementedByUsingJavaXPathCode)
  }

  private def verifyThatBookTitlesCanBeRetrievedFromBookstoreXml(
    bookstoreInformationRetriever: BookstoreInformationRetriever // the abstract trait with two implementations
  ) {
    verifyBookTitle("Everyday Italian",  1, bookstoreInformationRetriever)
    verifyBookTitle("Harry Potter",      2, bookstoreInformationRetriever)
    verifyBookTitle("XQuery Kick Start", 3, bookstoreInformationRetriever)
    verifyBookTitle("Learning XML",      4, bookstoreInformationRetriever)

    verifyBookTitle(null,                5, bookstoreInformationRetriever)
    verifyBookTitle(null,                0, bookstoreInformationRetriever)
    verifyBookTitle(null,               -1, bookstoreInformationRetriever)
  }
  
  private def verifyBookTitle(
    expectedTitle: String,
    bookItemNumber: Int,
    bookstoreInformationRetriever: BookstoreInformationRetriever
  ) {
    assertEquals(
      "Failing bookItemNumber: " + bookItemNumber + " for implementation: " + bookstoreInformationRetriever.getClass,
      expectedTitle,
      bookstoreInformationRetriever.getBookTitleFromBookstoreXml(bookstoreXml, bookItemNumber)
    )
  }
}