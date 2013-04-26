package xmlAndXpath

import scala.xml.Elem
import scala.xml.NodeSeq
import scala.xml.Node

class BookstoreInformationRetrieverImplementedWithNativeScala extends BookstoreInformationRetriever {

  def getBookTitleFromBookstoreXml(xmlWithBooks: Elem, bookItemNumber: Int): String = {
    val nodeSequenceWithTitles: NodeSeq = xmlWithBooks \ "book" \ "title"
    val nodesWithTitles: List[Node] = nodeSequenceWithTitles.toList
    if( !( 1 <= bookItemNumber && bookItemNumber <= nodesWithTitles.size) ) return null
    val node: Node = nodesWithTitles(bookItemNumber-1)
    node.text
  }  
}