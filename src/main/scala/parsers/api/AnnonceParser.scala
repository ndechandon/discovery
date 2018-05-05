package parsers.api

import modeles.Annonce
import modeles.Annonce.AnnonceId
import org.jsoup.nodes.Document

trait AnnonceParser {
  def extract(doc :Document):Annonce

  def extractAnnonceDate(document: Document):String
  def extractId(document: Document):AnnonceId

}
