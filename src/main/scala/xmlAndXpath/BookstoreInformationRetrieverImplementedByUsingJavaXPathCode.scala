package xmlAndXpath

import XmlExtensionWithSomeXPathSupport.scalaXmlElementToXmlExtensionWithSomeXPathSupport

class BookstoreInformationRetrieverImplementedByUsingJavaXPathCode extends BookstoreInformationRetriever {

  def getBookTitleFromBookstoreXml(
    xmlWithBooks: scala.xml.Elem,
    bookItemNumber: Int
  ) : String = {
    val xPathExpression = "/bookstore/book[" + bookItemNumber + "]/title"

    val nodeList: org.w3c.dom.NodeList = xmlWithBooks.getNodeListMatchingXPathExpression(xPathExpression)
    
    if(nodeList.getLength < 1) return null
    nodeList.item(0).getFirstChild.getNodeValue
  }
}