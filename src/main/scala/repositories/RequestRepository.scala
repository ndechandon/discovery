package repositories

import referentiel.{Request, RequestJsonSerializer}
import referentiel.Request.RequestId

import scala.util.{Success, Try}

trait RequestRepository extends  Repository [Request,RequestId]{

  override def store(e: Request): Try[RequestId] =  {

    println(RequestJsonSerializer.serialize(e))
    Success("")
  }
}