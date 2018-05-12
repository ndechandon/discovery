package parsers.annonce.JsonParser

import documentClients.LocalClientDoc
import org.json4s.jackson.JsonMethods._
import org.jsoup.select.Elements
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class AttributParserSpec extends FlatSpec with Matchers {

  val localClient = new LocalClientDoc()
  val testFile = getClass
    .getClassLoader
    .getResource("parsers/car/voiture.html")
    .getPath
  val testDocument = localClient.get(testFile).get


  val scriptParser = new ScriptParser {}
  "getAllScriptTags" should "return a list of 11 element" in {
    val result: Elements = scriptParser.getAllScriptTags(testDocument)
    result.size() shouldBe 11
  }

  "collectElementsToJvalue" should "return one filter JValue object" in {
    val testData= scriptParser.getAllScriptTags(testDocument)
    val result = scriptParser.collectElementsToJvalue(testData)
    compact(render(result.\("routing") \ "locationBeforeTransitions" \ "pathname")) should equal( "\"/voitures/1427320207.htm/\"")
  }
}