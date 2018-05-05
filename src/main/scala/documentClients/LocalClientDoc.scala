package documentClients

import java.io.File

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

import scala.util.{Failure, Success, Try}

class LocalClientDoc(encoding: String = "UTF-8") extends ClientDoc {

  override def get(path: String): Try[Document] = {
    try {
      val input: File = new File(path)
      Success (Jsoup.parse(input, encoding))
    } catch {
      case t:Throwable => Failure(t)
    }

  }

}
