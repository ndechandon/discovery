package modeles

import modeles.Annonce.AnnonceId

trait Annonce {
  val id: AnnonceId
  val annonceDate: String
}

object Annonce {
  type AnnonceId = String

}