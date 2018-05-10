package repositories

import referentiel.Annonce.AnnonceId
import referentiel.{Annonce, AnnonceJsonSerializer}

import scala.util.{Success, Try}

class AnnonceRepository(datapath: DataFileSystemPath) extends Repository[Annonce, AnnonceId] {

  override def store(e: Annonce): Try[AnnonceId] = {
    val toSave = AnnonceJsonSerializer.serialize(e)
    writeToPath(toSave, datapath.requestPathFIle(e.id))
      .transform(_ => Success(e.id), t => util.Failure(t))
  }

  override def load(id: AnnonceId): Try[Annonce] = {
    getContentFromFile(datapath.requestPathFIle(id)).map { data =>
      AnnonceJsonSerializer.deserialize(data)
    }
  }
}