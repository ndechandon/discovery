package repositories

import referentiel.Annonce.AnnonceId
import referentiel.Request.RequestId

class DataFileSystemPath (workingDir :String= System.getProperty("user.dir")) {

  val DataPath = s"${workingDir}/data/"
  val RequestCarPath = s"${DataPath}/car/requests"
  val AnnonceCarPath = s"${DataPath}/car/annonce"


  def requestPathFIle(requestId: RequestId): String = {
    s"${RequestCarPath}/${requestId}.json"
  }

  def carAnnoncePathFIle(annonceId: AnnonceId): String = {
    s"${AnnonceCarPath}/${annonceId}.json"
  }

}
