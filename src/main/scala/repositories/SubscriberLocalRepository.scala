package repositories


import referentiel.Subscriber
import referentiel.annonce.RequestJsonSerializer

import scala.util.{Success, Try}

class SubscriberLocalRepository(datapath: DataFileSystemPath) extends LocalRepository {

  //todo test it
def store(subscribers: List[Subscriber]): Try[Unit] = {
    val toSave =  RequestJsonSerializer.serialize(subscribers)
    writeToPath(toSave, datapath.SubscriberFile)
      .transform( _ => Success(),t =>util.Failure(t))

  }
  def list(): Try[List[Subscriber]] = {
    getContentFromFile(datapath.SubscriberFile).map{data =>
      RequestJsonSerializer.deserialize(data)
    }

  }



}