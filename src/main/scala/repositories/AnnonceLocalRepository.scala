package repositories

import referentiel.Annonce.AnnonceId
import referentiel.AnnonceJsonSerializer
import referentiel.annonce.{Annonce, AnnonceJsonSerializer}

import scala.util.{Success, Try}

class AnnonceLocalRepository(datapath: DataFileSystemPath) extends LocalRepository {

   def store(e: Annonce): Try[AnnonceId] = {
    val toSave = AnnonceJsonSerializer.serialize(e)
    writeToPath(toSave, datapath.carAnnoncePathFIle(e.id))
      .transform(_ => Success(e.id), t => util.Failure(t))
  }

  def load(id: AnnonceId): Try[Annonce] = {
    getContentFromFile(datapath.carAnnoncePathFIle(id)).map { data =>
      AnnonceJsonSerializer.deserialize(data)
    }
  }

}