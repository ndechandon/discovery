package parsers.api

import org.jsoup.nodes.Document
import referentiel.Request

trait IndexParser {

  def extract(doc :Document): List[Request]

}