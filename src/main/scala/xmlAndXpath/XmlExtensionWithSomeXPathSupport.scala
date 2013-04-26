package xmlAndXpath

import org.w3c.dom.NodeList
import xml.PrettyPrinter

object XmlExtensionWithSomeXPathSupport {
  implicit def scalaXmlElementToXmlExtensionWithSomeXPathSupport(xml: scala.xml.Elem) = {
    val xmlString = prettyPrinterUsedForConvertingXmlElementToString.format(xml)
    new XmlExtensionWithSomeXPathSupport(xmlString)
  }
  private val prettyPrinterUsedForConvertingXmlElementToString = new PrettyPrinter(100, 1)
}

class XmlExtensionWithSomeXPathSupport(private val xml: String) {
  def getNodeListMatchingXPathExpression(xPathExpression: String) : NodeList = {
    XmlFacade.getNodeListMatchingXPathExpression(xml, xPathExpression)
  }
}