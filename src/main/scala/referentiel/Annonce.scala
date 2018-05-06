package referentiel

import referentiel.Annonce.AnnonceId

trait Annonce {
  val id: AnnonceId
  val annonceDate: String
}

object Annonce {
  type AnnonceId = String

}