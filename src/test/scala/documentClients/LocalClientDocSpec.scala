package documentClients

import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Failure, Success}

class LocalClientDocSpec extends FlatSpec with Matchers {

  val localClient = new LocalClientDoc()

  "get with good path" should "return a Success of  document" in {
    val path = "parsers/car/index.html"
    val fullPath: String = getClass.getClassLoader.getResource(path).getPath()
    localClient.get(fullPath) shouldBe  a [Success[_]]

  }
  "get with bad path" should "return a Failure of  document" in {
    val path = "wrong"
    localClient.get(path) shouldBe  a [Failure[_]]

  }

}
