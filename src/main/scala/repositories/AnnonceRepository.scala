package repositories

import org.json4s.Extraction
import referentiel.Annonce
import referentiel.Annonce.AnnonceId

import scala.util.{Success, Try}

trait AnnonceRepository extends  Repository [Annonce,AnnonceId]{

  override def store(e: Annonce): Try[AnnonceId] =  {
    println(e)

    Success("")
  }
}