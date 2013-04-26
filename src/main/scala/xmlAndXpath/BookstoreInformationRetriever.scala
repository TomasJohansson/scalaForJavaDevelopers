package xmlAndXpath

import scala.xml.Elem

trait BookstoreInformationRetriever {
  def getBookTitleFromBookstoreXml(xmlWithBooks: Elem, bookItemNumber: Int): String
}