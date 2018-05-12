package repositories

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}
import referentiel.Subscriber

import scala.util.Success
@RunWith(classOf[JUnitRunner])
class SubscriberLocalRepositorySpec  extends FlatSpec with Matchers {



  val datapath =new DataFileSystemPath("/tmp")
  val repo = new SubscriberLocalRepository(datapath)

  "Store a list of Subscriber" should "" in {


    val dataTest = List(Subscriber("AAA","http:/AAA","BORN","BAEBY"),
      Subscriber("BBB","http:/BBB","BORN","BAEBY"),
      Subscriber("CCC","http:/CCC","BORN","BAEBY"),
      Subscriber("DDD","http:/DDD","BORN","BAEBY"))

    repo.store(dataTest)
    repo.list() shouldBe Success(dataTest)
  }




}


