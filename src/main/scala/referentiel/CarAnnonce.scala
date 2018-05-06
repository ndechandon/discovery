package referentiel

import referentiel.Annonce.AnnonceId


case class CarAnnonce(
                       override val id: AnnonceId,
                       override val annonceDate: String,
                       title: String,
                       price: String,
                       brand: String,
                       model: String,
                       relaeseDate: String,
                       mileage: String,
                       fuel: String,
                       gearbox: String,
                       description: String

                     ) extends Annonce {

}
