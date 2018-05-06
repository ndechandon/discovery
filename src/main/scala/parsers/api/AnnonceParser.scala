package parsers.api

import referentiel.Annonce
import referentiel.Annonce.AnnonceId
import org.jsoup.nodes.Document

trait AnnonceParser {
  def extract(doc :Document):Annonce

  def extractAnnonceDate(document: Document):String
  def extractId(document: Document):AnnonceId

}
