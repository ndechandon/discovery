package parsers.JSONParser

import documentClients.LocalClientDoc
import org.json4s.DefaultFormats
import org.jsoup.select.Elements
import org.json4s.JsonAST.JValue
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.json4s.jackson.JsonMethods._
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class ScriptParserSpec extends FlatSpec with Matchers {

  val localClient = new LocalClientDoc()
  val testFile = getClass
    .getClassLoader
    .getResource("parsers/car/annonce.html")
    .getPath
  val testDocument = localClient.get(testFile).get

  val scriptParser = new ScriptParser {}

  "getAllScriptTags" should "return a list of 11 element" in {
    val result: Elements = scriptParser.getAllScriptTags(testDocument)
    result.size() shouldBe 11
  }


  "collectElementsToJvalue" should "return one filter JValue object" in {
    val testData = scriptParser.getAllScriptTags(testDocument)
    val result = scriptParser.collectElementsToJvalue(testData)
    compact(render(result.\("routing") \ "locationBeforeTransitions" \ "pathname")) should equal("\"/voitures/1427320207.htm/\"")
  }

  "extractAttributs" should "re" in {
    val jsonObject = scriptParser.collectElementsToJvalue(scriptParser.getAllScriptTags(testDocument))
    val attribut = scriptParser.extractAttributs(jsonObject)

    attribut.size shouldBe 6
    attribut.head shouldBe Attribut("brand", "Volkswagen", "Marque", "Volkswagen", true)


  }
  "getValueFromAttribut with correct key" should "the value af the key" in {
    val jsonObject = scriptParser.collectElementsToJvalue(scriptParser.getAllScriptTags(testDocument))
    val attributs = scriptParser.extractAttributs(jsonObject)
    scriptParser.getValueFromAttribut(attributs, "brand") shouldBe "Volkswagen"
  }


  "getValueFromAttribut" should "do ??" in {
    val jsonObject = scriptParser.collectElementsToJvalue(scriptParser.getAllScriptTags(testDocument))
    val attributs = scriptParser.extractAttributs(jsonObject)
    println(scriptParser.getValueFromAttribut(attributs, "unknow"))
  }
}