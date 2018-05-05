package documentClients

import org.jsoup.nodes.Document

import scala.util.Try

trait ClientDoc {

  def get(path: String): Try[Document]
}
