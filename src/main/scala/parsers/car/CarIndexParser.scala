package parsers.car

import modeles.Request
import org.jsoup.nodes.{Document, Element}
import parsers.api.IndexParser

import scala.collection.JavaConversions._
import scala.util.{Success, Try}

object CarIndexParser extends IndexParser {

  override def extract(doc: Document) : Try[List[Request]] = {
    val listAnnonces = getElmentFromDocument(doc)
    //todo get erro

    Success( listAnnonces.map { element =>
      Request(
        extractURL(element),
        extractID(element)
      )
    })
  }

  def getElmentFromDocument(doc: Document): List[Element] =
  //Fixme remove pub
    doc.getElementsByClass("list_item").toList

  def extractID(element: Element): String =
    element.getElementsByClass("saveAd").attr("data-savead-id")

  def extractURL(element: Element): String = element.attr("href")
}

