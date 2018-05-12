package repositories

import java.io.{File, FileWriter, PrintWriter}

import scala.io.Source
import scala.util.{Failure, Success, Try}

trait LocalRepository {

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

  def getListOfFiles(path: String):List[File] = {
    val d = new File(path)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

}