package repositories

import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Failure, Try}


class RepositorySpec extends FlatSpec with Matchers {

  val repo = new Repository[String, String] {

    override def load(id: String): Try[String] = ???
    override def store(e: String): Try[String] = ???
  }

  val readFile = getClass
    .getClassLoader
    .getResource("repositories/read.txt")
    .getPath

  val writeFile = getClass
    .getClassLoader
    .getResource("repositories/write.txt")
    .getPath

  "getContentFromfile" should "a string contening a String of the file " in {
    val result = repo.getContentFromFile(readFile).get
    result should include("Hello word")
    result should include("1234")
    result should include("â$*%")

  }

  "getContentFromfile" should " failed because file doesn't exites" in {
    val result = repo.getContentFromFile("wrong file path")
    result shouldBe a[Failure[_]]

  }

  "writeToPath" should "" in {
    val content = "I Want to write this ...."
    val result = repo.writeToPath(content, writeFile)
    repo.getContentFromFile(writeFile).get should be(content)
  }

}
