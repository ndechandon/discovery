package parsers.api

import java.io.File

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Failure, Success}

@RunWith(classOf[JUnitRunner])
class ParserSpec extends FlatSpec with Matchers {

  val parser = new Parser {}
  "getDocumentFromFile with good file" should "return a Success of document" in {

    val path = getClass.getResource("parsers/car/index.html").getPath
    val input: File = new File(path)
    parser.getDocumentFromFile(input) shouldBe a[Success[_]]

  }

  "getDocumentFromFile with bad url" should "return a Failure ofdocument" in {
    val input: File = new File("wrongPath")
    parser.getDocumentFromFile(input) shouldBe a[Failure[_]]

  }

}
