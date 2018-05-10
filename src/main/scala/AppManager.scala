import documentClients.{LocalClientDoc, WebClientDoc}
import repositories.{DataFileSystemPath, RequestRepository}
import services.CarService

class AppManager {

  val confifPath = new DataFileSystemPath()
  val requestRepo = new RequestRepository(confifPath)

  //clients
  val localClient = new LocalClientDoc()
  val webClient = new WebClientDoc()

  //services
  val carService = new CarService(webClient, requestRepo)


}
