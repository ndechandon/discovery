package referentiel

import org.json4s.{DefaultFormats, Extraction, Formats}
import org.json4s.native.JsonMethods._


trait JsonSerializer[T] {
  val formats = DefaultFormats

  def serialize(caseClass: T): String = {
    pretty(render(Extraction.decompose(caseClass)(formats)))
  }

  def deserialize(json: String)
                 (implicit mf: scala.reflect.Manifest[T]): T = {
    parse(json).extract[T](formats, mf)
  }
}

object RequestJsonSerializer extends JsonSerializer[Request]{

}
