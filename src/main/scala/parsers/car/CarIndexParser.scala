package parsers.car

import org.jsoup.nodes.{Document, Element}
import parsers.api.IndexParser
import referentiel.Request

import scala.collection.JavaConversions._

object CarIndexParser extends IndexParser {

  override def extract(doc: Document): List[Request] = {
    val listAnnonces = getElmentFromDocument(doc)
    //todo get erro

    listAnnonces.map { element =>
      Request(
        extractURL(element),
        extractID(element)
      )
    }
  }

  def getElmentFromDocument(doc: Document): List[Element] =
  //Fixme remove pub
    doc.getElementsByClass("list_item").toList

  def extractID(element: Element): String =
    element.getElementsByClass("saveAd").attr("data-savead-id")

  def extractURL(element: Element): String = element.attr("href")
}

