package parsers.api

import org.jsoup.nodes.Document
import referentiel.Annonce.AnnonceId
import referentiel.annonce.Annonce

trait AnnonceParser {
  def extract(doc :Document):Annonce

//  def extractAnnonceDate(document: Document):String
 // def extractId(document: Document):AnnonceId

}
