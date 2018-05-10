import services.CarService
import documentClients.LocalClientDoc
import repositories.{DataFileSystemPath, RequestRepository}

object main {


  def main(args: Array[String]): Unit = {
    println("Start program")

    //repo

    val objectManager = new AppManager

    val first = "https://www.leboncoin.fr/voitures/offres/?th=1&location=Chassieu%2069680&pe=6"
    objectManager.carService.getIndex(first)

//todo
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
