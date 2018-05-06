package services

import documentClients.LocalClientDoc
import org.scalatest.{FlatSpec, Matchers}
import repositories.{DataFileSystemPath, RequestRepository}

class CarServiceSpec extends FlatSpec with Matchers {


  "serialize a object" should "return a valide json string" in {

  //repo
  val confifPath = new DataFileSystemPath()
  val requestRepo = new RequestRepository(confifPath)

  //clients
  val localClient = new LocalClientDoc()

  //services
  val carService = new CarService(localClient, requestRepo)


  val path = "parsers/car/index.html"
  val fullPath: String = getClass.getClassLoader.getResource(path).getPath()


  carService.getIndex(fullPath)
  }
}
