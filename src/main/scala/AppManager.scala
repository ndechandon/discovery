import documentClients.{LocalClientDoc, WebClientDoc}
import repositories.{AnnonceLocalRepository, DataFileSystemPath, SubscriberLocalRepository}
import services.CarService
import urlIterator.UrlCarIndex

class AppManager {

  val confifPath = new DataFileSystemPath()
  val requestRepo = new SubscriberLocalRepository(confifPath)
  val annonceRepo = new AnnonceLocalRepository(confifPath)

  //clients
  val localClient = new LocalClientDoc()
  val webClient = new WebClientDoc()

  //services
  val carService = new CarService(webClient, requestRepo,annonceRepo)

  val urlCarIndex= new UrlCarIndex()


}
