package services

import documentClients.ClientDoc
import parsers.ShortAnnonceParser
import parsers.annonce.CarAnnonceParser
import referentiel.Subscriber
import repositories.{AnnonceLocalRepository, SubscriberLocalRepository}

import scala.util.{Failure, Success, Try}

class CarService(clientDoc: ClientDoc, indexRepo: SubscriberLocalRepository, annonceRepo: AnnonceLocalRepository) {


  def getIndex(url: String): List[Subscriber] = {
    val doc = clientDoc.get(url)
    println("get resquest")

    doc match {
      case Success(t) => {
        val result = ShortAnnonceParser.extract(t)
          .filter { r => r.id.nonEmpty && r.id != "" }
        //result.foreach(indexRepo.store)
        result
      }
      case Failure(t) => Nil

    }
  }

  def getAnnonce(requests: List[Subscriber]) = {


    requests.map { request =>
      Thread.sleep(1000)
      clientDoc.get(s"http:${request.url}").map {
        doc =>
          println("get ANNONCE")
          val annonce = CarAnnonceParser.extract(doc)
          println(annonce)
          annonceRepo.store(annonce)
      }

    }
  }
}


