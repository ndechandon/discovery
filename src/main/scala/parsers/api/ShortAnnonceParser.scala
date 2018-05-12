package parsers.api

import org.jsoup.nodes.Document
import referentiel.Subscriber

trait ShortAnnonceParser {

  def extract(doc :Document): List[Subscriber]

}