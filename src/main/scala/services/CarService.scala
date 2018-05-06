package services

import documentClients.ClientDoc
import parsers.car.CarIndexParser
import repositories.RequestRepository

import scala.util.Success

class CarService(clientDoc: ClientDoc, indexRepo: RequestRepository) {


  def getIndex(url: String) = {
    val doc = clientDoc.get(url)

    doc match {
      case Success(t) => {
        CarIndexParser.extract(t).map { r =>
          if(r.id.nonEmpty && r.id != "") {
            indexRepo.store(r)
          }
        }

      }
    }


  }
}
