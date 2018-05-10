package repositories


import referentiel.Request.RequestId
import referentiel.{Request, RequestJsonSerializer}

import scala.util.{Success, Try}

class RequestRepository(datapath: DataFileSystemPath) extends Repository[Request, RequestId] {

//todo test it
  override def store(e: Request): Try[RequestId] = {

    val toSave = RequestJsonSerializer.serialize(e)
    writeToPath(toSave, datapath.requestPathFIle(e.id))
      .transform( _ => Success(e.id),t =>util.Failure(t))

  }

  override def load(id: RequestId): Try[Request] = {
    getContentFromFile(datapath.requestPathFIle(id)).map{data =>
      RequestJsonSerializer.deserialize(data)
    }

  }


}