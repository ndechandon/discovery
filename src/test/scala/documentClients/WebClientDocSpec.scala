package documentClients

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Failure, Success}


@RunWith(classOf[JUnitRunner])
class WebClientDocSpec extends FlatSpec with Matchers {

  val httpClient = new WebClientDoc()

  "post with good url" should "return a Success of  document" in {
    val url = "http://www.google.com/search?q=httpClient"
    httpClient.post(url) shouldBe  a [Success[_]]

  }

  "post with bad url" should "return a Failure of document" in {
    val url = "innconnue"
    httpClient.post(url) shouldBe a[Failure[_]]

  }

  "get with good url" should "return a Success of  document" in {
    val url = "https://www.leboncoin.fr/annonces/demandes/?th=1&q=a"
    httpClient.get(url) shouldBe a [Success[_]]

  }

  "get with bad url" should "return a Failure of document" in {
    val url = "innconnue"
    httpClient.get(url) shouldBe a[Failure[_]]

  }

}


