package parsers.api

import referentiel.Request
import org.jsoup.Jsoup
import org.jsoup.nodes.{Document, Element}

import scala.util.{Failure, Success, Try}

trait IndexParser {

  def extract(doc :Document): List[Request]

}