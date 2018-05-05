package documentClients

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

import scala.util.{Failure, Success, Try}

class WebClientDoc(timeOut:Int=3000, userAgent:String= "Mozilla") extends ClientDoc {

  def post(path: String): Try[Document] = {
    transaction(Jsoup.connect(path)
      .userAgent(userAgent)
      .timeout(timeOut)
      .post())
  }

 override def get(path: String): Try[Document] = {
    transaction(Jsoup.connect(path)
      .userAgent(userAgent)
      .timeout(timeOut)
      .get())
  }

  protected def transaction(f: => Document): Try[Document] = {
    try {
      val result = f
      Success(result)
    } catch {
      case t: Throwable => Failure(t)
    }
  }
}


