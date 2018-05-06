package referentiel

import referentiel.Request.RequestId

case class Request(url: String,
                   id: RequestId) {
}

object Request {
  type RequestId = String

}