package parsers.car

import org.jsoup.nodes.Document
import parsers.api.AnnonceParser
import referentiel.Annonce.AnnonceId
import referentiel.CarAnnonce

object CarAnnonceParser extends AnnonceParser {

  override def extract(doc: Document): CarAnnonce = {

    CarAnnonce(
      extractID(doc),
      extractDate(doc),
      extractTitle(doc),
      extractPrice(doc),
      extractBrand(doc),
      extractModel(doc),
      extractRelaseDate(doc),
      extractMileage(doc),
      extractFuel(doc),
      extractGearBox(doc),
      extractDescription(doc)
    )
  }

  override def extractId(document: Document): AnnonceId = ???
  override def extractAnnonceDate (document: Document): AnnonceId = ???

  def extractID(doc :Document):String = ???
  def extractDate(doc :Document):String = ???
  def extractTitle(doc :Document):String = ???
  def extractPrice(doc :Document):String = ???
  def extractBrand(doc :Document):String = ???
  def extractModel(doc :Document):String = ???
  def extractRelaseDate(doc :Document):String = ???
  def extractMileage(doc :Document):String = ???
  def extractFuel(doc :Document):String = ???
  def extractGearBox(doc :Document):String = ???
  def extractDescription(doc :Document):String = ???




}
