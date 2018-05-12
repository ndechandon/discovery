package parsers.annonce.JsonParser

import documentClients.LocalClientDoc
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class ScriptParserSpec extends FlatSpec with Matchers {

  val localClient = new LocalClientDoc()
  val testFile = getClass
    .getClassLoader
    .getResource("parsers/car/voiture.html")
    .getPath
  val testDocument = localClient.get(testFile).get

  val scriptParser = new ScriptParser {}


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