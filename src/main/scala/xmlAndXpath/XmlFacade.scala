package xmlAndXpath

import java.io.StringReader

import org.w3c.dom.Document
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource

import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

object XmlFacade {

  def getNodeListMatchingXPathExpression(xml: String , xPathExpression: String) : NodeList = {
    val document = getInputSourceAsDocument(getXmlStringAsInputSource(xml))
    getNodeListMatchingXPathExpression(document, xPathExpression)
  }

  private val xPath = XPathFactory.newInstance().newXPath()

  private def getNodeListMatchingXPathExpression(
    node: Node,
    xPathExpressionAsString: String
  ) : NodeList = {
    val xPathExpression = xPath.compile(xPathExpressionAsString)
    val nodesFoundByXPathExpression = xPathExpression.evaluate(node, XPathConstants.NODESET)
    nodesFoundByXPathExpression.asInstanceOf[NodeList]
  }

  private val documentBuilderFactory = DocumentBuilderFactory.newInstance()
  documentBuilderFactory.setNamespaceAware(true)
  private val documentBuilder = documentBuilderFactory.newDocumentBuilder()

  private def getInputSourceAsDocument(xmlInputSource: InputSource) : Document = {
    documentBuilder.parse(xmlInputSource)
  }

  private def getXmlStringAsInputSource(xmlString: String): InputSource = {
    val reader = new StringReader(xmlString);
    new InputSource(reader);
  }
}