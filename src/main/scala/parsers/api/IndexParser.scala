package parsers.api

import modeles.Request
import org.jsoup.Jsoup
import org.jsoup.nodes.{Document, Element}

import scala.util.{Failure, Success, Try}

trait IndexParser {

  def extract(doc :Document): Try[List[Request]]

}