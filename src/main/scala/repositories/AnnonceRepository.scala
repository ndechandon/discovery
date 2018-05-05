package repositories

import modeles.Annonce
import modeles.Annonce.AnnonceId

import scala.util.{Success, Try}

trait AnnonceRepository extends  Repository [Annonce,AnnonceId]{

  override def store(e: Annonce): Try[AnnonceId] =  {
    println(e)
    Success("")
  }
}