package parsers.api

import org.jsoup.nodes.Document
import referentiel.Annonce
import referentiel.Annonce.AnnonceId

trait AnnonceParser {
  def extract(doc :Document):Annonce

  def extractAnnonceDate(document: Document):String
  def extractId(document: Document):AnnonceId

}
