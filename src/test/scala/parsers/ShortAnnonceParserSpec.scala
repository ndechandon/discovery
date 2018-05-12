package parsers

import documentClients.LocalClientDoc
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class ShortAnnonceParserSpec extends FlatSpec with Matchers with BeforeAndAfterAll {

  val localClient = new LocalClientDoc()
  val testFile = getClass
    .getClassLoader
    .getResource("parsers/index.html")
    .getPath

  val testDocument = localClient.get(testFile).get

  "extract document" should "return the URL" in {
    val result = ShortAnnonceParser.extract(testDocument)
    result.head.url shouldBe "//www.leboncoin.fr/voitures/1424397699.htm?ca=22_s"
  }

  "extract document" should "return the id" in {
    val result = ShortAnnonceParser.extract(testDocument)
    result.head.id shouldBe "1424397699"
  }

  "extract document" should "xx element" in {
    val result = ShortAnnonceParser.extract(testDocument)
    result.size shouldBe 24

  }

}
