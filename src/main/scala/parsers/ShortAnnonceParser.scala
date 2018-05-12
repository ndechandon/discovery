package parsers

import org.jsoup.nodes.{Document, Element}
import parsers.api.ShortAnnonceParser
import referentiel.annonce.ShortAnnonce

import scala.collection.JavaConversions._

object ShortAnnonceParser extends ShortAnnonceParser {

  override def extract(doc: Document): List[ShortAnnonce] = {
    val listAnnonces = getElmentFromDocument(doc)
    //todo get erro

    listAnnonces.map { element =>
      ShortAnnonce(
        extractID(element),
        extractURL(element)
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

