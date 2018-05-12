package referentiel.annonce


case class CarAnnonce(
                       override val id: AnnonceId,
                       override val annonceDate: String,
                       title: String,
                       price: String,
                       brand: String,
                       model: String,
                       mileage: String,
                       fuel: String,
                       gearbox: String,
                       description: String

                     ) extends Annonce {

}
