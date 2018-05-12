package repositories

import referentiel.Annonce.AnnonceId

class DataFileSystemPath (workingDir :String= s"${System.getProperty("user.dir")}/data/") {

  val DataPath = s"${workingDir}"
  val SubscriberFile = s"${DataPath}/subscriber.json"
  val AnnonceCarPath = s"${DataPath}/car/annonces"


  def carAnnoncePathFIle(annonceId: AnnonceId): String = {
    s"${AnnonceCarPath}/${annonceId}.json"
  }

}
