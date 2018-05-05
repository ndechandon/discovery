package services

import documentClients.ClientDoc
import modeles.Request
import parsers.car.CarIndexParser
import repositories.{AnnonceRepository, Repository}

import scala.util.Try

class CarService(clientDoc: ClientDoc, repo:AnnonceRepository ) {


  def getIndex(url:String)= {

    val result= for {
      doc <- clientDoc.get(url)
      request <- CarIndexParser.extract(doc)
    } yield request

    result.get.foreach(x => println(x))
  }



}
