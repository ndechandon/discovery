package parsers.car

import documentClients.LocalClientDoc
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}
import referentiel.CarAnnonce

@RunWith(classOf[JUnitRunner])
class CarAnnonceParserSpec extends FlatSpec with Matchers with BeforeAndAfterAll {

  val localClient = new LocalClientDoc()
  val testFile = getClass
    .getClassLoader
    .getResource("parsers/car/annonce.html")
    .getPath
  val testDocument = localClient.get(testFile).get

  "extract document wih a bad document" should "" in {

    val badfile = getClass
      .getClassLoader
      .getResource("parsers/car/index.html")
      .getPath

    val badDocument = localClient.get(badfile).get
  //  val data = CarAnnonceParser.extract(badDocument)

  }

  "extract document" should "return the good id" in {
    val annonce = CarAnnonceParser.extract(testDocument)

    println(annonce)
    //annonce.id shouldBe 0
  }


}
