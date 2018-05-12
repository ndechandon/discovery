import services.CarService
import documentClients.LocalClientDoc
import repositories.{DataFileSystemPath, SubscriberLocalRepository}

object main {


  def main(args: Array[String]): Unit = {
    println("Start program")

    //repo

    val objectManager = new AppManager

    val  generator = objectManager.urlCarIndex
    for ( x <- 1 to 10) {

      println(s"INFO : Get Request $x")
      val requests = objectManager.carService.getIndex(generator.next())


      println(s"INFO : Get Annonce $x")
      objectManager.carService.getAnnonce(requests)
    }




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
