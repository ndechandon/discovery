package parsers.car

import org.json4s.JsonAST.JValue
import org.json4s.jackson.JsonMethods._
import org.jsoup.nodes.Document
import parsers.JSONParser.{AttributParser, ScriptParser}
import parsers.api.AnnonceParser
import referentiel.CarAnnonce

object CarAnnonceParser extends AnnonceParser with ScriptParser  {

  override def extract(doc: Document): CarAnnonce = {

    val selectElements = getAllScriptTags(doc)
    val jValueAnnonce = collectElementsToJvalue(selectElements)
    val attributs = extractAttributs(jValueAnnonce)

    CarAnnonce(
      id = getFromAdview(jValueAnnonce, "list_id"),
      annonceDate = getFromAdview(jValueAnnonce, "first_publication_date"),
      title = getFromAdview(jValueAnnonce, "subject"),
      price = getFromAdview(jValueAnnonce, "price"),
      brand = getValueFromAttribut(attributs, "brand"),
      model = getValueFromAttribut(attributs, "model"),
      relaeseDate = getValueFromAttribut(attributs, "brand"),
      mileage = getValueFromAttribut(attributs, "mileage"),
      fuel = getValueFromAttribut(attributs, "fuel"),
      gearbox = getValueFromAttribut(attributs, "gearbox"),
      description = getFromAdview(jValueAnnonce, "body")
    )
  }


  def getFromAdview(jsonObject: JValue, key: String) = compact(render(jsonObject \ "adview" \ key))
}
