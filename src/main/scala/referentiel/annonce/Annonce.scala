package referentiel.annonce

trait Annonce {
  val id: AnnonceId
  val annonceDate: String
}

object Annonce {
  type AnnonceId = String

}