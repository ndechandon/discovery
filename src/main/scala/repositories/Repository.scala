package repositories

import java.io.{File, FileWriter, PrintWriter}

import scala.io.Source
import scala.util.{Failure, Success, Try}

trait Repository[T, ID] {

  def load(id: ID): Try[T]

  def store(e: T): Try[ID]

  def writeToPath(content: String, path: String): Try[Unit] = {
    val file = new File(path)
    println(path)
    file.createNewFile()
    val pw = new PrintWriter(new FileWriter(file))

    try {
      Success(pw.write(content))

    } catch {
      case t: Throwable => Failure(t)
    } finally {
      pw.close()
    }
  }

  def getContentFromFile (path: String): Try[String] ={
    try {
      Success(Source.fromFile(path).mkString(""))
    } catch {
      case t: Throwable => Failure(t)
    }

  }

}