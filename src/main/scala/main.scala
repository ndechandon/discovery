import services.CarService
import documentClients.LocalClientDoc
import repositories.{DataFileSystemPath, RequestRepository}

object main {


  def main(args: Array[String]): Unit = {
    println("Start program")


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

//todo
    // repo local fileSytem
    // test réel
    // test parsing request
    // affinage parsing annonce remove pub

    // parsing annonce
    //test réel
    // & SQL
    // loger officiel
    // automatisaion import annonce, rattrapage et update on need
    println("End program")
  }


}
