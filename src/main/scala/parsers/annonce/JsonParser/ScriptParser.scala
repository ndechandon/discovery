package parsers.annonce.JsonParser

import org.json4s.JsonAST.JValue
import org.json4s.jackson.JsonMethods.parse
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

import scala.collection.JavaConversions._


trait ScriptParser extends AttributParser {

  val jsonVariable = "window.FLUX_STATE"

  def getAllScriptTags(doc: Document): Elements = doc.getElementsByTag("script")

  def collectElementsToJvalue(elements: Elements, patern: String=jsonVariable): JValue = {
    val nodesStringfied = elements.flatMap(_.dataNodes().map(_.getWholeData)).toList

    val jsonToParse = nodesStringfied.filter(
      rs => rs.contains(patern)).head.replaceAll(s"$patern = ", "")
    parse(jsonToParse)
  }


}
